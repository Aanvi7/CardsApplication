/**
 * 
 */
package com.shubh.cards.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.shubh.cards.config.CardServiceConfig;
import com.shubh.cards.model.Cards;
import com.shubh.cards.model.Customer;
import com.shubh.cards.model.Properties;
import com.shubh.cards.repository.CardsRepository;




@RestController
public class CardsController {
	private static final Logger logger = LoggerFactory.getLogger(CardsController.class);

	@Autowired
	private CardsRepository cardsRepository;
	
	@Autowired
	private CardServiceConfig config;
	

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		logger.info("getPropertyDetails() method started  ");
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		logger.info("getPropertyDetails() method ended  ");

		if (cards != null) {
			return cards;
		} else {
			return null;
		}

	}
	@GetMapping("/card/properties")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter objectWriter=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(config.getMsg(), config.getBuildVersion(), config.getMailDetails(), config.getActiveBranches());
		String jsonStr=objectWriter.writeValueAsString(properties);
		
		return jsonStr;

}}
