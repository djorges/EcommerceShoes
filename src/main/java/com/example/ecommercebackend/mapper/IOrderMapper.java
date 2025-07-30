package com.example.ecommercebackend.mapper;

import com.example.ecommercebackend.dto.OrderDTO;
import com.example.ecommercebackend.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*@Mapper(componentModel = "spring", uses = {IOrderItemMapper.class})
public interface IOrderMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "items", target = "orderItems")
    OrderDTO toDTO(Order order);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "orderItems", target = "items")
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDTOs(List<Order> orders);

    List<Order> toEntities(List<OrderDTO> orderDTOs);
}*/
