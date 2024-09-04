package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AboutController {

    @GetMapping("/about")
    public String getAbout() {
        return "About";
    }
}
