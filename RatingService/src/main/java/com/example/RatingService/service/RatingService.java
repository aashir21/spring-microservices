package com.example.RatingService.service;

import com.example.RatingService.dto.RatingDTO;
import com.example.RatingService.model.Rating;
import com.example.RatingService.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String createRating(Rating rating){
        ratingRepository.save(rating);

        return "RATING CREATED";
    }

    public List<RatingDTO> getAllRatings(){
        return ratingRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<RatingDTO> getRatingsByCustomerId(Long customerId){

        return ratingRepository.findByCustomerId(customerId)
                .stream().map(this::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    public List<RatingDTO> getRatingsByAirlineId(Long airlineId){

        return ratingRepository.findByAirlineId(airlineId)
                .stream().map(this::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    public RatingDTO convertEntityToDTO(Rating rating){

        RatingDTO ratingDTO = new RatingDTO();

        ratingDTO = modelMapper.map(rating, RatingDTO.class);

        return ratingDTO;
    }

}
