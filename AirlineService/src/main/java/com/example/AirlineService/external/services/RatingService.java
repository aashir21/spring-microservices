package com.example.AirlineService.external.services;

import com.example.AirlineService.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/getRatingsByAirlineId/{airlineId}")
    List<Rating> getRatingsByAirlineId(@PathVariable Long airlineId);

}
