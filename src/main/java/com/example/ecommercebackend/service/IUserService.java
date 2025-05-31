package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    @Transactional(readOnly = true)
    UserEntity findById(Long id);

    @Transactional(readOnly = true)
    List<UserEntity> findAll();

    @Transactional
    UserEntity save(UserEntity entity);

    @Transactional
    void deleteById(Long id);
}
