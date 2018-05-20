package com.in28minutes.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        System.out.println("pppppppppppppppppp");
        model.addAttribute("message", "in28Minutes");
        return "welcome";
    }
}
