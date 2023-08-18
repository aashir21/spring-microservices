package com.example.AirlineService.external.services;

import com.example.AirlineService.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {

    @GetMapping("/customers/getCustomerByIdForAirline/{customerId}")
    Customer getCustomerByIdForAirline(@PathVariable Long customerId);

}
