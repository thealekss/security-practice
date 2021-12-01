package com.example.security_custom_users_storage.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    public String adminPage(Principal principal) {
        return String.format("Welcome, '%s'. You are at highly secured page.", principal.getName());
    }
}
