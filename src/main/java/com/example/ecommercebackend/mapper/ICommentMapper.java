package com.example.ecommercebackend.mapper;

import com.example.ecommercebackend.dto.CommentDTO;
import com.example.ecommercebackend.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICommentMapper {
    @Mapping(source = "user.id", target = "userId")
    CommentDTO toDto(Comment comment);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "product", ignore = true)
    Comment toEntity(CommentDTO commentDTO);
}
