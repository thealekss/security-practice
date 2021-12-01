package com.example.security_custom_users_storage.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String homePage(Principal principal) {
        if (principal != null) {
            return String.format("Welcome, '%s'. You are at homepage of website.", principal.getName());
        }
        else return "Welcome, guest";
    }
}
