# Spring Boot Microservices: Airline, Rating, and Customer Services

Welcome to the Git repository for the Spring Boot microservices project showcasing the Airline, Rating, and Customer services. This project demonstrates the microservices architecture utilizing Eureka Server for service discovery, an API Gateway for routing, and Feign Client for efficient communication between services.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)


## Overview

In this microservices architecture, we have three main services: Airline Service, Rating Service, and Customer Service. These services are designed to interact with each other through a combination of service discovery, routing, and simplified communication.

## Technologies Used

- Java
- Spring Boot
- Eureka Server
- API Gateway
- Feign Client

## Project Structure

The repository structure is organized as follows:

spring-microservices-demo/
│
├── eureka-server/
│ ├── src/
│ └── pom.xml
│
├── api-gateway/
│ ├── src/
│ └── pom.xml
│
├── airline-service/
│ ├── src/
│ └── pom.xml
│
├── rating-service/
│ ├── src/
│ └── pom.xml
│
├── customer-service/
│ ├── src/
│ └── pom.xml
│
└── README.md

- `eureka-server`: Contains the Eureka Server application for service registration and discovery.
- `api-gateway`: Implements the API Gateway to route requests to the appropriate microservices and perform load balancing.
- `airline-service`, `rating-service`, `customer-service`: These are the core microservices, each responsible for its specific functionality. They communicate with each other through the API Gateway.
- `pom.xml`: Maven configuration files for each module.
