package com.groupefbo.apitransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class APiTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(APiTransportApplication.class, args);
	}

	@Bean
	public Module hibernate5Module() {
		return new Hibernate5Module();
	}
}
