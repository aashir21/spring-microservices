package com.example.CustomerService.external.services;

import com.example.CustomerService.model.Airline;
import com.example.CustomerService.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/getRatingsByCustomerId/{customerId}")
    List<Rating> getRatingsByCustomerId(@PathVariable Long customerId);

}
