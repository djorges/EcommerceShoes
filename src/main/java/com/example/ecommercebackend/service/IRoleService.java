package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.RoleEntity;
import com.example.ecommercebackend.entity.enums.RoleType;
import org.springframework.transaction.annotation.Transactional;

public interface IRoleService {
    @Transactional(readOnly = true)
    RoleEntity findByName(RoleType roleType);
}
