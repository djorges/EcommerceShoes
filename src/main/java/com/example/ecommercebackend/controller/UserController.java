package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<UserEntity>();
        return users;
    }

    @GetMapping("/user/userId")
    public UserEntity getUserById(Long id) {
        return new UserEntity();
    }
}
