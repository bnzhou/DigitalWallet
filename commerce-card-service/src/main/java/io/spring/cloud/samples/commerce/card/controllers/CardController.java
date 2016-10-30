package io.spring.cloud.samples.commerce.card.controllers;

import io.spring.cloud.samples.commerce.card.domain.Card;
import io.spring.cloud.samples.commerce.card.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardRepository repository;

    @RequestMapping("/cards")
    public Iterable<Card> items() {
        return repository.findAll();
    }

    @RequestMapping("/getbyUser/{usr}")
    public Iterable<Card> cardsByUsername(@PathVariable("usr") String username) {
      Iterable<Card> Cards = repository.findByUsername(username);
      return Cards;
    }

    @RequestMapping("/getbyID/{id}")
    public Card cardsByID(@PathVariable("id") String id) {
        Card card = repository.findOne(id);
        return card;
    }

    @RequestMapping("/getbyIDtest/{id}")
    public String cardsByID_test(@PathVariable("id") String id) {
        Card card = repository.findOne(id);
        return card.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteCardByID(@PathVariable("id") String id) {
        if(repository.exists(id)) {
            repository.delete(id);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCard(@RequestParam("cardNum") String cardNum,
                           @RequestParam("username") String username,
                           @RequestParam("cardHolder") String cardHolder,
                           @RequestParam("cardType") String cardType,
                           @RequestParam("expireDate") String expireDate,
                           @RequestParam("secureNum") String secureNum,
                           @RequestParam("description") String description) {
        if(repository.exists(cardNum)) {
            return "False";
        }
        Card newCard = new Card(cardNum, username, cardHolder, cardType, expireDate, secureNum, description);

        repository.save(newCard);
        return "True";
    }
}
