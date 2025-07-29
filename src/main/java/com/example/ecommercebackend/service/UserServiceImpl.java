package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {
    private final IUserRepository repository;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = repository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User " + username + " not found")
        );
        val authority = new SimpleGrantedAuthority(user.getRole().getName().name());

        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(authority)
        );
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
