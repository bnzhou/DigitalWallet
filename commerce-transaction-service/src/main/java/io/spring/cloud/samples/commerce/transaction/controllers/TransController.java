package io.spring.cloud.samples.commerce.transaction.controllers;

import io.spring.cloud.samples.commerce.transaction.domain.Transaction;
import io.spring.cloud.samples.commerce.transaction.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransController.class);

    @Autowired
    AddressRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTrans(@RequestParam("id") String id,
                           @RequestParam("username") String username,
                           @RequestParam("cardnum") String cardnum,
                           @RequestParam("address") String address,
                           @RequestParam("timestamp") String timestamp) {
        if(repository.exists(id)) {
            return "False";
        }
        Transaction newTrans = new Transaction(id, username, cardnum, address, timestamp);

        repository.save(newTrans);
        return id;
    }

    @RequestMapping("/getbyUser/{usr}")
    public Iterable<Transaction> addrByUsername(@PathVariable("usr") String username) {
        Iterable<Transaction> Addrs = repository.findByUsername(username);
        return Addrs;
    }

    @RequestMapping("/getbyID/{id}")
    public Transaction addrByID(@PathVariable("id") String id) {
        Transaction trans = repository.findOne(id);
        return trans;
    }

    @RequestMapping("/getbyIDtest/{id}")
    public String addrByID_test(@PathVariable("id") String id) {
        Transaction trans = repository.findOne(id);
        return trans.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteAddrByID(@PathVariable("id") String id) {
        if(repository.exists(id)) {
            repository.delete(id);
            return "true";
        }
        return "false";
    }
}
