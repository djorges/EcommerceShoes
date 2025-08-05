package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.ChangePasswordReqDTO;
import com.example.ecommercebackend.dto.NewUserReqDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IAuthService {
    String login(String username, String password);

    void register(NewUserReqDTO newUserReqDTO);

    void changePassword(String email, ChangePasswordReqDTO request);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
