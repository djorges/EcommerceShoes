package com.example.ecommercebackend.mapper;

import com.example.ecommercebackend.dto.ProductDTO;
import com.example.ecommercebackend.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {ICommentMapper.class})
public interface IProductMapper {
    @Mapping(source = "comments", target = "commentDTOList")
    ProductDTO toDTO(Product product);

    @Mapping(source = "commentDTOList", target = "comments")
    Product toEntity(ProductDTO productDTO);
}
