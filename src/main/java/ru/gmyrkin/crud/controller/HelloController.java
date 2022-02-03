package ru.gmyrkin.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/index")
    public String printWelcome(ModelMap model) {

        return "index";
    }
}



