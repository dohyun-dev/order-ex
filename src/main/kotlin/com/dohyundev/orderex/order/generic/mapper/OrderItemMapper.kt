package com.dohyundev.orderex.order.generic.mapper

import com.dohyundev.orderex.order.command.entity.OrderItem
import com.dohyundev.orderex.order.generic.dto.OrderItemDto
import org.springframework.stereotype.Component

@Component
class OrderItemMapper {

    fun toDto(orderItem: OrderItem): OrderItemDto {
        return OrderItemDto(
            id = orderItem.id,
            productId = orderItem.productId,
            quantity = orderItem.quantity,
            price = orderItem.price
        )
    }

    fun toDtoList(orderItems: List<OrderItem>): List<OrderItemDto> {
        return orderItems.map { toDto(it) }
    }
}
