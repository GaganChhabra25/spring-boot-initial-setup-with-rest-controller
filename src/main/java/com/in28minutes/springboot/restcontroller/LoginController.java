package com.in28minutes.springboot.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @RequestMapping(name = "/", method = RequestMethod.GET, produces =  "application/json")
    public String login() {
        return "Login Successfull";
    }
}
