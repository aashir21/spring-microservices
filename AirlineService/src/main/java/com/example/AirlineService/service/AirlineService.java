package com.example.AirlineService.service;

import com.example.AirlineService.dto.AirlineDTO;
import com.example.AirlineService.external.services.CustomerService;
import com.example.AirlineService.external.services.RatingService;
import com.example.AirlineService.model.Airline;
import com.example.AirlineService.model.Customer;
import com.example.AirlineService.model.Rating;
import com.example.AirlineService.repository.AirlineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private CustomerService customerService;


    public String createAirline(Airline airline){

        airlineRepository.save(airline);

        return "AIRLINE CREATED";

    }

    public List<AirlineDTO> getAllAirlines(){

        List<AirlineDTO> list = airlineRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .toList();

        return list;
    }

    public AirlineDTO getAirlineById(Long airlineId){

        AirlineDTO airlineDTO = airlineRepository.findById(airlineId).map(this::convertEntityToDTO).get();
        List<Rating> ratings = ratingService.getRatingsByAirlineId(airlineId);

        ratings.forEach(rating ->{
            rating.setCustomer(customerService.getCustomerByIdForAirline(rating.getCustomerId()));
        });

        airlineDTO.setRatingList(ratings);

        return airlineDTO;
    }


    public AirlineDTO convertEntityToDTO(Airline airline){

        AirlineDTO airlineDTO = new AirlineDTO();

        airlineDTO = modelMapper.map(airline, AirlineDTO.class);

        return airlineDTO;

    }

}
