package com.example.CustomerService.service;

import com.example.CustomerService.dto.CustomerDTO;
import com.example.CustomerService.external.services.AirlineService;
import com.example.CustomerService.external.services.RatingService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.Rating;
import com.example.CustomerService.publisher.CustomerProducer;
import com.example.CustomerService.repository.CustomerRepository;
import com.example.CustomerService.validation.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private CustomerProducer customerProducer;


    public String createCustomer(Customer customer){

        customerRepository.save(customer);

        return "USER CREATED";
    }

    public List<CustomerDTO> getAllCustomers(){

        List<Customer> list = customerRepository.findAll();

        list.forEach(item ->{
            List<Rating>ratings = ratingService.getRatingsByCustomerId(item.getCustomerId());

            ratings.forEach(rating ->{
                rating.setAirline(airlineService.getAirlineById(rating.getAirlineId()));
            });

            item.setRatings(ratings);

        });

        return list.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long customerId){

        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new ResourceNotFoundException("Customer not found with id: " + customerId);
        }

        CustomerDTO customerDTO = customerRepository.findById(customerId).map(this::convertEntityToDto).get();

        List<Rating> ratings  =  ratingService.getRatingsByCustomerId(customerId);

        ratings.forEach(rating ->{
            rating.setAirline(airlineService.getAirlineById(rating.getAirlineId()));
        });

        customerDTO.setRatings(ratings);

        return customerDTO;

    }

    public CustomerDTO getCustomerByIdForAirline(Long id){

        CustomerDTO customerDTO = customerRepository.findById(id).map(this::convertEntityToDto).get();

        return customerDTO;
    }

    public CustomerDTO convertEntityToDto(Customer customer){

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return customerDTO;

    }

    public List<Rating> getRatingsMadeByCustomer(Long customerId){

        List<Rating> list = ratingService.getRatingsByCustomerId(customerId);

        customerProducer.sendMessage(list);

        return list;
    }

}
