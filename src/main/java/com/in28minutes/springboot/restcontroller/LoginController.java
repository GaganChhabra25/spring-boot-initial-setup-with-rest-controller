package com.in28minutes.springboot.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String login() {
        return "Login Successfull";
    }
}
