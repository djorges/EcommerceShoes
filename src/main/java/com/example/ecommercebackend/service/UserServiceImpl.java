package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) repository.findAll();
    }

    @Transactional
    @Override
    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        findById(id);

        repository.deleteById(id);
    }
}
