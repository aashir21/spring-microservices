package com.example.RatingService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Airline {

    private Long airlineId;
    private String name;
    private String country;
    private String code;

}
