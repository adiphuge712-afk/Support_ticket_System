package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.models"})
public class SpringBootStartTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartTaskApplication.class, args);
	}

}
