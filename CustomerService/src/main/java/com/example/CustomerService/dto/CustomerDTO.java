package com.example.CustomerService.dto;

import com.example.CustomerService.model.Airline;
import com.example.CustomerService.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private String name;
    private String email;
    private List<Rating> ratings = new ArrayList<>();


}
