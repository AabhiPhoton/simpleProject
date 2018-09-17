package net.photon.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.photon.springboot.model.Person;
import net.photon.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@Api(value = "Summary", description = "Displays the welcome message and has rest calls for people summary")
@RestController
public class SummaryController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Performs Get operation and gives welcome message")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstMessage(){
        return "Welcome to Photon Spring Boot Training Example";
    }


    @ApiOperation(value = "Gets JSON for all the persons from the dB")
    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}
