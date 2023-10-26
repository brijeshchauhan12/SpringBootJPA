package com.springbootcore.springg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Value("${welcome.message}")
    private String defaultPageMessage;
    @GetMapping("/")
    public String helloWorld(){

        return defaultPageMessage;
    }
}
