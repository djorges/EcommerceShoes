package com.example.ecommercebackend.mapper;


import com.example.ecommercebackend.dto.CartDTO;
import com.example.ecommercebackend.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/* TODO: Create Cart, Order, Product, mapper
    https://mapstruct.org/documentation/1.5/reference/html/
        CartDto cartDto = CartMapper.INSTANCE.toDto( cart );

*/
@Mapper(componentModel = "spring", uses = {ICartItemMapper.class})
public interface ICartMapper {

    @Mapping(source = "user.id", target = "userId")
    CartDTO toDTO(Cart cart);

    @Mapping(source = "userId", target = "user.id")
    Cart toEntity(CartDTO dto);
}
