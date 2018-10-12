package net.photon.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    public List<PersonBean> getAllPersons() {
        return personService.getAllPersonBeans();
    }

    @ApiOperation(value = "Gets JSON for person of the requested Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonBean> getPerson(@PathVariable long id) {
        PersonBean person = personService.getPersonBean(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Gets JSON for person(s) by the requested first Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    //"/user?value={name}"
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonBean>> getPersonByName(@RequestParam("value") final String name) {

        System.out.println("In controller");
        System.out.println("name = " + name);

        if (name.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<PersonBean> persons = personService.getPersonBeansByName(name);
        if (persons == null || persons.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

//    @ApiOperation(value = "Gets JSON for person(s) by the requested first Name")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 404, message = "Resource not found")
//    })
//    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<PersonBean>> getPersonByName(@PathVariable final String name) {
//
//        System.out.println("In controller");
//        System.out.println("name = " + name);
//
//        if (name.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        List<PersonBean> persons = personService.getPersonBeansByName(name);
//        if (persons == null || persons.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(persons, HttpStatus.OK);
//    }


    @ApiOperation(value = "Gets JSON for person(s) by the requested Last Name for query /user/lastName?value={lastName}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Resource not found")
    })
    //"/user?lName={name}"
    @RequestMapping(value = "/user/lastName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonBean>> getPersonByLastName(@RequestParam("lName") final String lastName) {

        System.out.println("In getPersonByLastName");
        System.out.println("Last Name value = " + lastName);

        if (lastName.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<PersonBean> persons = personService.getPersonsByLastName(lastName);
        if (persons == null || persons.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(persons, HttpStatus.OK);
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


    @ApiOperation(value = "deletes a person in the database")
    @RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
