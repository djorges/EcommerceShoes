package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.RoleEntity;
import com.example.ecommercebackend.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleType name);
}
