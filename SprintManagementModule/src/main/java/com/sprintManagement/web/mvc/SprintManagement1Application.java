package com.sprintManagement.web.mvc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprintManagement1Application {

	// Creating Bean for model mapping
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SprintManagement1Application.class, args);
		System.out.println("Running successfully.....");
	}

}
