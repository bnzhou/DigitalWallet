package io.spring.cloud.samples.commerce.addressservice.controllers;

import io.spring.cloud.samples.commerce.addressservice.domain.Login;
import io.spring.cloud.samples.commerce.addressservice.repositories.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginRepository repository;

    @RequestMapping("/login")
    public String items(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        Login user = repository.findOne(username);
        if(user != null && password.equals(user.getPassword())) {
            return "Success";
        }

        return "Fail";
    }

    @RequestMapping("/admin")
    public String items(@PathParam("username") String username) {
        Login user = repository.findOne(username);
        if(user != null) {
            return user.toString();
        }

        return "Not found";
    }
}
