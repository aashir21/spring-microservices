package com.example.RatingService.dto;

import com.example.RatingService.model.Airline;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RatingDTO {

    private Long customerId;
    private Long airlineId;
    private String feedback;

}
