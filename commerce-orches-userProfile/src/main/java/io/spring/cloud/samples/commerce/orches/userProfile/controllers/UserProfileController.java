package io.spring.cloud.samples.commerce.orches.userProfile.controllers;

import io.spring.cloud.samples.commerce.orches.userProfile.services.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserProfileController {

    @Autowired
    CommerceService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        return service.login(username, password);
    }

    @RequestMapping(value ="/cardAdd", method = RequestMethod.POST)
    public String addCard(@RequestParam("cardNum") String cardNum,
                          @RequestParam("username") String username,
                          @RequestParam("cardHolder") String cardHolder,
                          @RequestParam("cardType") String cardType,
                          @RequestParam("expireDate") String expireDate,
                          @RequestParam("secureNum") String secureNum,
                          @RequestParam("description") String description) {
        return service.addCard(cardNum, username, cardHolder, cardType, expireDate, secureNum, description);
    }

    @RequestMapping("/cardGetByUser")
    public String getCardsbyUser(@PathParam("username") String username) {
        return service.getCardByUser(username);
    }

    @RequestMapping("/cardDelete")
    public String deteleCard(@PathParam("cardNum") String cardNum,
                             @PathParam("username") String username) {
        return service.deleteCard(username, cardNum);
    }

    @RequestMapping(value ="/addressAdd", method = RequestMethod.POST)
    public String addAddress(@RequestParam("id") String id,
                      @RequestParam("username") String username,
                      @RequestParam("address") String address) {
    return service.addAddress(id, username, address);
}

    @RequestMapping("/addressGetByUser")
    public String getAddresssbyUser(@PathParam("username") String username) {
        return service.getAddressByUser(username);
    }

    @RequestMapping("/addressDelete")
    public String deteleAddress(@PathParam("id") String id,
                             @PathParam("username") String username) {
        return service.deleteAddress(username, id);
    }

}
