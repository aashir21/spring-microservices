package com.example.AirlineService.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airline-tbl")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;
    @NotNull(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Country cannot be empty")
    private String country;
    @NotNull(message = "Code cannot be empty")
    private String code;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
