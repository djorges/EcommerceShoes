package com.example.ecommercebackend.service;


import com.example.ecommercebackend.dto.NewUserDTO;
import com.example.ecommercebackend.entity.RoleEntity;
import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.entity.enums.RoleType;
import com.example.ecommercebackend.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
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

        return jwtUtil.generateToken(authResult);
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
    public String logout(HttpServletRequest request, HttpServletResponse response) {
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            val authHeader = request.getHeader("Authorization");
            String jwtToken = null;
            String userName = null;
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwtToken = authHeader.substring(7);
                userName = jwtUtil.getUsername(jwtToken);
            }

            if(userName != null) {
                UserDetails userDetails = userService.loadUserByUsername(userName);

                if (jwtUtil.validateToken(jwtToken, userDetails)) {
                    //TODO:
                     RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                    // If no matching token is found, throws an exception for a non-existing refresh token
                    .orElseThrow(() -> new BusinessException(ERROR, REFRESH_TOKEN_DOES_NOT_EXIST));

                    // Sets the status of the found refresh token to REVOKED, marking it as unusable
                    refreshToken.setRefreshTokenStatus(RefreshTokenStatus.REVOKED);

                    // Saves the updated refresh token back to the database to persist the status change
                    refreshTokenRepository.save(refreshToken);
                    new SecurityContextLogoutHandler().logout(request, response, authentication);
                }
            }
        }*/
        return "";
    }
}
