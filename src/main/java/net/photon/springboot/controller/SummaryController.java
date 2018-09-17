package net.photon.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Summary", description = "Displays the welcome message and has rest calls for people summary")
@RestController
public class SummaryController {


    @ApiOperation(value = "Performs Get operation and gives welcome message")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstMessage(){
        return "Welcome to Photon Spring Boot Training Example";
    }
}
