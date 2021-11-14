package com.javafsd.AzureRavali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureRavaliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureRavaliApplication.class, args);
	}
	 
		@GetMapping("/hellooo")
		public String hello() {
		return "Hello! Welocme to Azure........123456789";
		}
}
