package com.example.CustomerService.controller;

import com.example.CustomerService.dto.CustomerDTO;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.Rating;
import com.example.CustomerService.publisher.CustomerProducer;
import com.example.CustomerService.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerProducer customerProducer;


    @PostMapping("/createCustomer")
    public String createCustomer(@Valid @RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/getCustomerByIdForAirline/{customerId}")
    public CustomerDTO getCustomerByIdForAirline(@PathVariable Long customerId){

        return customerService.getCustomerByIdForAirline(customerId);
    }

    @GetMapping("/getRatingsMadeByCustomer/{customerId}")
    public List<Rating> getRatingsMadeByCustomer(@PathVariable Long customerId){

        return customerService.getRatingsMadeByCustomer(customerId);

    }


}
