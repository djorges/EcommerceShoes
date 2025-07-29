package com.example.ecommercebackend.mapper;


import com.example.ecommercebackend.dto.CartDTO;
import com.example.ecommercebackend.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



/* TODO: Create Cart, Order, Product, mapper
    https://mapstruct.org/documentation/1.5/reference/html/
        CartDto cartDto = CartMapper.INSTANCE.toDto( cart );

*/
@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper( CartMapper.class );

    @Mapping(source = "user.id", target = "userId")
    CartDTO toDTO(Cart cart);

    @Mapping(source = "userId", target = "user.id")
    Cart toEntity(CartDTO dto);
}