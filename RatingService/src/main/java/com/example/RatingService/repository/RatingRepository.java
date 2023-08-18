package com.example.RatingService.repository;

import com.example.RatingService.dto.RatingDTO;
import com.example.RatingService.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByCustomerId(Long customerId);
    List<Rating> findByAirlineId(Long airlineId);

}
