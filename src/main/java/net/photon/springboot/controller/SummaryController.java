package net.photon.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.photon.springboot.beans.PersonBean;
import net.photon.springboot.model.Person;
import net.photon.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@Api(value = "Summary", description = "Displays the welcome message and has rest calls for people summary")
@RestController
public class SummaryController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Performs Get operation and gives welcome message")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstMessage() {
        return "Welcome to Photon Spring Boot Training Example";
    }


    @ApiOperation(value = "Gets JSON for all the persons from the dB")
    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @ApiOperation(value = "Gets JSON for person of the requested Id")
    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonBean> getPerson(@PathVariable long id) {
        PersonBean person = personService.getPersonBean(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Adds a new person to the database")
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        boolean save = personService.save(person);
        if (save) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
