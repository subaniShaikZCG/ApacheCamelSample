package com.camelSample.camelMicroServiceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelMicroServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelMicroServiceAApplication.class, args);
		System.out.println("apacheCamelForIntegrating");
	}

}
