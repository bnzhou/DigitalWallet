package io.spring.cloud.samples.commerce.orches.checkout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CheckoutService {

    @Autowired
    RestTemplate restTemplate;

    public String login(String username, String password) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> paras= new LinkedMultiValueMap<String, String>();
        paras.add("username", username);
        paras.add("password", password);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(paras, headers);

        String result = restTemplate.postForObject("http://login/login", request, String.class);
        if(result.equals("Success")) {
            String ret = restTemplate.getForObject("http://login/get/{usr}", String.class, username);
            return "success";
        }
        return "fail";
    }

    public String addTrans(String id, String username, String cardnum,
                          String address, String timestamp) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> paras= new LinkedMultiValueMap<String, String>();
        paras.add("id", id);
        paras.add("username", username);
        paras.add("cardnum", cardnum);
        paras.add("address", address);
        paras.add("timestamp", timestamp);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(paras, headers);

        String result = restTemplate.postForObject("http://trans/add", request, String.class);
        return result;
    }

    public String getCardByUser(String usr) {

        // get data from remote services
        Iterable<LinkedHashMap> items = restTemplate.getForObject("http://card/getbyUser/{usr}", Iterable.class, usr);

        StringBuilder result = new StringBuilder();

        // combine item info with price
        Iterator<LinkedHashMap> it = items.iterator();
        while (it.hasNext()) {
            LinkedHashMap curr = it.next();
            result.append("Card: ")
                    .append(curr.toString())
                    .append("\n");
        }

        // output the result
        return result.toString();
    }

    public String getAddressByUser(String usr) {

        // get data from remote services
        Iterable<LinkedHashMap> items = restTemplate.getForObject("http://addr/getbyUser/{usr}", Iterable.class, usr);

        StringBuilder result = new StringBuilder();

        // combine item info with price
        Iterator<LinkedHashMap> it = items.iterator();
        while (it.hasNext()) {
            LinkedHashMap curr = it.next();
            result.append("Address: ")
                    .append(curr.toString())
                    .append("\n");
        }

        // output the result
        return result.toString();
    }

    public String deleteTrans(String id, String username) {
        Map<String, String> curr = restTemplate.getForObject("http://trans/getbyID/{id}", Map.class, id);
        if(curr!= null && username.equals(curr.get("userName"))) {
            String ret = restTemplate.getForObject("http://trans/delete/{id}", String.class, id);
            return ret;
        }
        return "You do not have this Transaction.";
    }

    // All transaction information we have
    public String validateTrans(String transID, String money) {
        return "true";
    }
}
