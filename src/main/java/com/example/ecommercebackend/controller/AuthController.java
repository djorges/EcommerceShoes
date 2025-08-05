package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.dto.ChangePasswordReqDTO;
import com.example.ecommercebackend.dto.NewUserReqDTO;
import com.example.ecommercebackend.service.IAuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody NewUserReqDTO newUserReqDTO
    ) {
        String jwt = authService.login(newUserReqDTO.getUsername(), newUserReqDTO.getPassword());

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
        @Valid @RequestBody NewUserReqDTO newUserReqDTO
    ) {
        authService.register(newUserReqDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully");
    }
    /**
     * TODO: Test change password method
     * http://localhost:8080/auth/change-password?email=
     *
     * */
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @RequestParam String email,
            @RequestBody ChangePasswordReqDTO request
    ) {
        authService.changePassword(email, request);

        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        authService.logout(request, response);

        return ResponseEntity.ok("Logout successful");
    }
}
