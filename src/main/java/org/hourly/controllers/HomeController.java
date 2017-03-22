package org.hourly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "World!");
        return "index";
    }
}
