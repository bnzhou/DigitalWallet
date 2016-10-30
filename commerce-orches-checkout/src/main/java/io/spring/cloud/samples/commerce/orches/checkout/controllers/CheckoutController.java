package io.spring.cloud.samples.commerce.orches.checkout.controllers;

import io.spring.cloud.samples.commerce.orches.checkout.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class CheckoutController {

    @Autowired
    CheckoutService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        String ret = service.login(username, password);
        if(ret.equals("fail")) {
            return "redirect:/index-1.html";
        }
        return "redirect:/pay.html";
    }

    @RequestMapping("/cardGetByUser")
    public String getCardsbyUser(@PathParam("username") String username) {
        return service.getCardByUser(username);
    }

    @RequestMapping("/addressGetByUser")
    public String getAddresssbyUser(@PathParam("username") String username) {
        return service.getAddressByUser(username);
    }

    @RequestMapping("/transDelete")
    public String deteleTrans(@PathParam("id") String id,
                             @PathParam("username") String username) {
        return service.deleteTrans(username, id);
    }

    @RequestMapping(value ="/transAdd", method = RequestMethod.POST)
    public String addTrans(@RequestParam("id") String id,
                          @RequestParam("username") String username,
                          @RequestParam("cardnum") String cardnum,
                          @RequestParam("address") String address,
                          @RequestParam("timestamp") String timestamp) {
        return service.addTrans(id, username, cardnum, address, timestamp);
    }

    @RequestMapping("/validateTrans")
    public String validateTrans(@PathParam("id") String id,
                              @PathParam("money") String money) {
        return service.validateTrans(id, money);
    }

}
