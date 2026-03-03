package com.example.mobileapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
@EnableCaching
@SpringBootApplication
public class MobileappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileappApplication.class, args);
		System.out.println("Mobile Application is running..........");
	}
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
