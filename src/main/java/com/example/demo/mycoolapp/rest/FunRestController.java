package com.example.demo.mycoolapp.rest;


import com.example.demo.mycoolapp.DbObjects.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class FunRestController {

    private static final String template = "Hello, %s!";
    private long  id = 1;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String sayHello(){
        return "{}";
    }
    @GetMapping("/user")
    public String loggingMethod(@RequestParam(value="user", defaultValue="") String user , @RequestParam(value="password", defaultValue="") String password) {
        User u = new User(id  ,user , password);
        try {
            return  mapper.writeValueAsString(u);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }



}
