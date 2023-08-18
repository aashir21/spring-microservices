package com.example.AirlineService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {

    private Long customerId;
    private Long airlineId;
    private String feedback;
    private Customer customer;
}
