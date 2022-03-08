package com.example.education_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {

        return "user";
    }
}



