package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.Cart;
import com.example.ecommercebackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByProductId(Long productId);
}