package com.dohyundev.orderex.order.generic.mapper

import com.dohyundev.orderex.order.command.entity.Order
import com.dohyundev.orderex.order.generic.dto.OrderDto
import org.springframework.stereotype.Component

@Component
class OrderMapper(
    private val orderItemMapper: OrderItemMapper,
    private val paymentMapper: PaymentMapper
) {

    fun toDto(order: Order): OrderDto {
        return OrderDto(
            id = order.id,
            items = orderItemMapper.toDtoList(order.items).toMutableList(),
            payments = paymentMapper.toDtoList(order.payments).toMutableList(),
            totalAmount = order.totalAmount,
            status = order.status
        )
    }

    fun toDtoList(orders: List<Order>): List<OrderDto> {
        return orders.map { toDto(it) }
    }
}
