package com.example.CustomerService.external.services;

import com.example.CustomerService.model.Airline;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AIRLINE-SERVICE")
public interface AirlineService {

    @GetMapping("/airlines/getAirlineById/{airlineId}")
    Airline getAirlineById(@PathVariable Long airlineId);

}
