package com.github.RafaWillian91.SpotMusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model){
        String message = "Hello, World!";
        model.addAttribute("message", message);
        return "home";
    }



}
