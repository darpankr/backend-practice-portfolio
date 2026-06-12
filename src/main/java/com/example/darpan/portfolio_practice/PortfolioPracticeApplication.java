package com.example.darpan.portfolio_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PortfolioPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioPracticeApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue = "Rahul") String name){
		return String.format("Hello " + name);
	}

}
