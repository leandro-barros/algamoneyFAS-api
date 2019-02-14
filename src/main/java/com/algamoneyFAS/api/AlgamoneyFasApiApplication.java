package com.algamoneyFAS.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.algamoneyFAS.api.config.property.AlgamoneyFasApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(AlgamoneyFasApiProperty.class)
public class AlgamoneyFasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyFasApiApplication.class, args);
	}

}

