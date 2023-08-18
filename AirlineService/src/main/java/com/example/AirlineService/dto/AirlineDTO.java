package com.example.AirlineService.dto;

import com.example.AirlineService.model.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AirlineDTO {

    private String name;
    private String country;
    private String code;
    private List<Rating> ratingList;

}
