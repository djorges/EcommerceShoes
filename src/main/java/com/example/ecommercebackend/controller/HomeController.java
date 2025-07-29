package com.example.ecommercebackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("home")
@RestController
public class HomeController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok("Hola, " + username + "!");
    }
}
