package com.example.ecommercebackend.service;


import com.example.ecommercebackend.dto.NewUserDTO;
import com.example.ecommercebackend.entity.RoleEntity;
import com.example.ecommercebackend.entity.TokenEntity;
import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.entity.enums.RoleType;
import com.example.ecommercebackend.repository.ITokenRepository;
import com.example.ecommercebackend.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final ITokenRepository tokenRepository; //TODO: Create token service
    private final UserServiceImpl userService;
    private final IRoleService roleService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(String username, String password) {
        val authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        val authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authResult);

        String name = authResult.getName();
        UserEntity user = userService.findByUsername(name);
        // Revocar tokens anteriores
        List<TokenEntity> validTokens = tokenRepository.findAllByUserAndRevokedFalseAndExpiredFalse(user);
        validTokens.forEach(t -> {
            t.setRevoked(true);
            t.setExpired(true);
        });
        tokenRepository.saveAll(validTokens);

        // Guardar nuevo token
        String jwt = jwtUtil.generateToken(authResult);
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken(jwt);
        tokenEntity.setUser(user);
        tokenEntity.setRevoked(false);
        tokenEntity.setExpired(false);
        tokenRepository.save(tokenEntity);

        return jwt;
    }

    @Override
    public void register(NewUserDTO newUserDTO) {
        if(userService.existsByUsername(newUserDTO.getUsername())) {
            throw new IllegalArgumentException("Username is already in use");
        }

        RoleEntity roleUser = roleService.findByName(RoleType.USER);

        UserEntity user = new UserEntity(
            newUserDTO.getUsername(),
            passwordEncoder.encode(newUserDTO.getPassword()),
            roleUser
        );

        userService.save(user);
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            val authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String jwtToken = authHeader.substring(7);
                String userName = jwtUtil.getUsername(jwtToken);

                UserEntity user = userService.findByUsername(userName);
                List<TokenEntity> validTokens = tokenRepository.findAllByUserAndRevokedFalseAndExpiredFalse(user);
                validTokens.forEach(t -> {
                    t.setRevoked(true);
                    t.setExpired(true);
                });
                tokenRepository.saveAll(validTokens);

                new SecurityContextLogoutHandler().logout(request, response, authentication);
            }
        }
    }
}
