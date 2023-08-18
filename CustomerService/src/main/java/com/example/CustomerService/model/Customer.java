package com.example.CustomerService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_tbl")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, message = "Name should be at least 3 characters")
    private String name;

    @Email(message = "Please check the format of email")
    @NotEmpty(message = "Email cannot be left empty")
    private String email;

    @Transient
    private List<Rating> ratings = new ArrayList<>();


}
