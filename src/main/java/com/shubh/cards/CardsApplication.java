package com.shubh.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScans({ @ComponentScan("com.shubh.cards.controller") })
@EnableJpaRepositories("com.shubh.cards.repository")
@EntityScan("com.shubh.cards.model")
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
		
		System.out.println("Cards Application is Running..on 82 poart..");
	}

}
