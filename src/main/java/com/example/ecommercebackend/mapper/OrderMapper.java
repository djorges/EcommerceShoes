package com.example.ecommercebackend.mapper;

import com.example.ecommercebackend.dto.OrderDTO;
import com.example.ecommercebackend.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "items", target = "orderItems")
    OrderDTO toOrderDto(Order order);
}
