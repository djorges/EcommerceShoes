package com.example.ecommercebackend.utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    /**
     * Called when a user tries to access a secured REST endpoint without providing valid credentials.
     *
     * @param request       the {@link HttpServletRequest} that resulted in an {@link AuthenticationException}
     * @param response      the {@link HttpServletResponse} to which the error response will be written
     * @param authException the exception that triggered this entry point
     * @throws IOException      in case of an input/output error
     * @throws ServletException in case of a general servlet exception
     */

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{\"error\": \"Unauthorized\"}");
    }
}
