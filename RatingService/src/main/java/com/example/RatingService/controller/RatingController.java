package com.example.RatingService.controller;

import com.example.RatingService.dto.RatingDTO;
import com.example.RatingService.model.Rating;
import com.example.RatingService.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/createRating")
    public String createRating(@Valid @RequestBody Rating rating){
        return ratingService.createRating(rating);
    }

    @GetMapping("/getAllRatings")
    public List<RatingDTO> getAllRatings(){

        return ratingService.getAllRatings();

    }

    @GetMapping("/getRatingsByCustomerId/{customerId}")
    public List<RatingDTO> getRatingsByCustomerId(@PathVariable Long customerId){

        return ratingService.getRatingsByCustomerId(customerId);

    }

    @GetMapping("/getRatingsByAirlineId/{airlineId}")
    public List<RatingDTO> getRatingsByAirlineId(@PathVariable Long airlineId){
        return ratingService.getRatingsByAirlineId(airlineId);
    }

}
