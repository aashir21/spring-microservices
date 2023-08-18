package com.example.AirlineService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AirlineServiceApplication {

	@Bean

	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

}
