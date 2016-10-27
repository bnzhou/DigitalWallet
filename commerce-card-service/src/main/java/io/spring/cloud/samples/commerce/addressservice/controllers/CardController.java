package io.spring.cloud.samples.commerce.addressservice.controllers;

import io.spring.cloud.samples.commerce.addressservice.domain.Card;
import io.spring.cloud.samples.commerce.addressservice.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardRepository repository;

    @RequestMapping("/cards")
    public Iterable<Card> items() {
        return repository.findAll();
    }

    @RequestMapping("/username/{usr}")
    public Iterable<Card> cardsByUsername(@PathVariable("usr") String username) {
      Iterable<Card> Cards = repository.findByUsername(username);
      return Cards;
    }

    @RequestMapping("/card/{id}")
    public Card cardsByID(@PathVariable("id") String id) {
        Card card = repository.findOne(id);
        return card;
    }
}
