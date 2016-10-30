package io.spring.cloud.samples.commerce.orches.userProfile.services;

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
public class CommerceService {

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
            return ret;
        }
        return result;
    }

    public String addCard(String cardNum, String username, String cardHolder,
                          String cardType, String expireDate, String secureNum,
                          String description) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> paras= new LinkedMultiValueMap<String, String>();
        paras.add("cardNum", cardNum);
        paras.add("username", username);
        paras.add("cardHolder", cardHolder);
        paras.add("cardType", cardType);
        paras.add("expireDate", expireDate);
        paras.add("secureNum", secureNum);
        paras.add("description", description);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(paras, headers);

        String result = restTemplate.postForObject("http://card/add", request, String.class);
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
                    .append("<br>");
        }

        // output the result
        return result.toString();
    }

    public String deleteCard(String usr, String cardNum) {
        Map<String, String> curr = restTemplate.getForObject("http://card/getbyID/{cardNum}", Map.class, cardNum);
        if(curr!= null && usr.equals(curr.get("userName"))) {
            String ret = restTemplate.getForObject("http://card/delete/{cardNum}", String.class, cardNum);
            return ret;
        }
        return "You do not have this card.";
    }

    public String addAddress(String id, String username, String address) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> paras= new LinkedMultiValueMap<String, String>();
        paras.add("id", id);
        paras.add("username", username);
        paras.add("address", address);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(paras, headers);

        String result = restTemplate.postForObject("http://addr/add", request, String.class);
        return result;
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
                    .append("<br>");
        }

        // output the result
        return result.toString();
    }

    public String deleteAddress(String usr, String id) {
        Map<String, String> curr = restTemplate.getForObject("http://addr/getbyID/{id}", Map.class, id);
        if(curr!= null && usr.equals(curr.get("username"))) {
            String ret = restTemplate.getForObject("http://addr/delete/{id}", String.class, id);
            return ret;
        }
        return "You do not have this address.";
    }


    public String getAllItems() {
        // get data from remote services
        Map<String, String> priceInfo = restTemplate.getForObject("http://price/prices", Map.class);
        Iterable<LinkedHashMap> items = restTemplate.getForObject("http://item/items", Iterable.class);

        StringBuilder result = new StringBuilder();

        // combine item info with price
        Iterator<LinkedHashMap> it = items.iterator();
        while (it.hasNext()) {
            LinkedHashMap curr = it.next();
            String id = String.valueOf(curr.get("id"));
            String price = priceInfo.get(id);
            result.append("Card: ")
                    .append(curr.toString())
                    .append("Price: ")
                    .append(price)
                    .append("<br>");
        }

        // output the result
        result.append("# of items: ").append(priceInfo.size());
        return result.toString();
    }
}
