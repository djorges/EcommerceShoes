package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.TokenEntity;
import com.example.ecommercebackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITokenRepository extends JpaRepository<TokenEntity, Long> {
    List<TokenEntity> findAllByUserAndRevokedFalseAndExpiredFalse(UserEntity user);

    Optional<TokenEntity> findByToken(String token);
}
