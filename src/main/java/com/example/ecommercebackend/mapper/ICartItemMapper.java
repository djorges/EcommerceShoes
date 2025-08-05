package com.example.ecommercebackend.mapper;

import com.example.ecommercebackend.dto.CartItemDTO;
import com.example.ecommercebackend.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface ICartItemMapper {

    @Mapping(source = "product.id", target = "productId")
    CartItemDTO toDTO(CartItem item);

    @Mapping(source = "productId", target = "product.id")
    CartItem toEntity(CartItemDTO dto);
}
