package io.spring.cloud.samples.commerce.address.controllers;

import io.spring.cloud.samples.commerce.address.repositories.AddressRepository;
import io.spring.cloud.samples.commerce.address.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAddr(@RequestParam("id") String id,
                          @RequestParam("username") String username,
                          @RequestParam("address") String address) {
        if(repository.exists(id)) {
            return "False";
        }
        Address newAddr = new Address(id, username, address);

        repository.save(newAddr);
        return "True";
    }

    @RequestMapping("/getbyUser/{usr}")
    public Iterable<Address> addrByUsername(@PathVariable("usr") String username) {
        Iterable<Address> Addrs = repository.findByUsername(username);
        return Addrs;
    }

    @RequestMapping("/getbyID/{id}")
    public Address addrByID(@PathVariable("id") String id) {
        Address addr = repository.findOne(id);
        return addr;
    }

    @RequestMapping("/getbyIDtest/{id}")
    public String addrByID_test(@PathVariable("id") String id) {
        Address addr = repository.findOne(id);
        return addr.toString();
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
