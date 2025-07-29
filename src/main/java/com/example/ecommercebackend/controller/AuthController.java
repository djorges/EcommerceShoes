package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.dto.NewUserDTO;
import com.example.ecommercebackend.service.IAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody NewUserDTO newUserDTO) {
        String jwt = authService.login(newUserDTO.getUsername(), newUserDTO.getPassword());

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody NewUserDTO newUserDTO) {
        authService.register(newUserDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully");
    }
    /**
     * TODO: Create reset password method
     * */
    /* TODO: logout
         https://medium.com/@klcberat13/jwt-authentication-and-secure-logout-in-spring-boot-e9dcff2cc677
    * */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        authService.logout(request, response);
        return ResponseEntity.ok("Logout successful");
    }
}
