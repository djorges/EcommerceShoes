package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.NewUserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface IAuthService {
    String login(String username, String password);

    void register(NewUserDTO newUserDTO);

    String logout(HttpServletRequest request, HttpServletResponse response);
}
