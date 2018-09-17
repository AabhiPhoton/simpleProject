package net.photon.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryController {


    @RequestMapping(value = "/")
    public String firstMessage(){
        return "Welcome to Photon Spring Boot Training Example";
    }
}
