package com.example.CustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Long customerId;
    private Long airlineId;
    private String feedback;
    private Airline airline;

}
