package io.spring.cloud.samples.commerce.login.controllers;

import io.spring.cloud.samples.commerce.login.domain.Login;
import io.spring.cloud.samples.commerce.login.repositories.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginRepository repository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        Login user = repository.findOne(username);
        if(user != null && password.equals(user.getPassword())) {
            return "Success";
        }

        return "Fail";
    }

    @RequestMapping("/get/{username}")
    public String getUserInfo(@PathVariable("username") String username) {
        Login user = repository.findOne(username);
        if(user != null) {
            return user.toString();
        }

        return "Not found";
    }
}
