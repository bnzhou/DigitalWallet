package io.spring.cloud.samples.commerce.addressservice.controllers;

import io.spring.cloud.samples.commerce.addressservice.domain.Address;
import io.spring.cloud.samples.commerce.addressservice.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class AddressController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressRepository repository;

    @RequestMapping("/address/{usr}")
    public Iterable<Address> addrByUsername(@PathVariable("usr") String username) {
        Iterable<Address> addrs = repository.findByUsername(username);
        return addrs;
    }

    @RequestMapping("/address/{id}")
    public Address addrByID(@PathVariable("id") String id) {
        Address addr = repository.findOne(id);
        return addr;
    }
}
