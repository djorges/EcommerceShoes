package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.RoleEntity;
import com.example.ecommercebackend.entity.enums.RoleType;
import com.example.ecommercebackend.repository.IRoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService{
    private final IRoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public RoleEntity findByName(RoleType roleType) {
        return roleRepository.findByName(roleType)
                .orElseThrow(()-> new EntityNotFoundException("Role does not exist"));

    }
}
