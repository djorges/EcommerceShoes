package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.NewUserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IAuthService {
    String login(String username, String password);

    void register(NewUserDTO newUserDTO);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
