package com.example.ecommercebackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RequestMapping("/home")
@RestController
public class HomeController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok("Hola, " + username + "!");
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getRoles(Authentication auth) {
        List<String> roles = auth.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/details")
    public ResponseEntity<Object> getAuthDetails(Authentication auth) {
        return ResponseEntity.ok(Map.of(
                "name", auth.getName(),
                "authorities", auth.getAuthorities(),
                "details", auth.getDetails(),
                "principal", auth.getPrincipal()
        ));
    }
}
