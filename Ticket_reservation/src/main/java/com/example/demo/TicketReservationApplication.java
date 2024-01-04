package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ticket_Reservation System",version = "18.0",description = "A Spring Boot application that, "
		+ "Creates and Manages API's for Ticket Reservation for the Passengers using Mongo DB and Docker."))
public class TicketReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketReservationApplication.class, args);
	}

}
