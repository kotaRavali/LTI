package com.javafsd.Azuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureDemoApplication.class, args);
	}
	 
	@GetMapping("/Hello")
	public String hello() {
	return "Hello! Welocme to Azure";
	}
}
