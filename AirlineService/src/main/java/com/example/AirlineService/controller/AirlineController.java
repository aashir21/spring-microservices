package com.example.AirlineService.controller;

import com.example.AirlineService.dto.AirlineDTO;
import com.example.AirlineService.model.Airline;
import com.example.AirlineService.service.AirlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @PostMapping("/createAirline")
    public String createAirline(@RequestBody Airline airline){

        return airlineService.createAirline(airline);

    }

    @GetMapping("/getAllAirlines")
    public List<AirlineDTO> getAllAirlines(){
        return airlineService.getAllAirlines();
    }

    @GetMapping("/getAirlineById/{airlineId}")
    public AirlineDTO getAirLineById(@PathVariable Long airlineId){
        return airlineService.getAirlineById(airlineId);
    }


}
