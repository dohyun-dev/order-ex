package com.dohyundev.orderex.order.command.ui.dto

import com.dohyundev.orderex.order.command.application.CreateOrderCommand
import com.dohyundev.orderex.order.command.ui.mapper.OrderItemRequestMapper
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty

class CreateOrderItemRequest(
    @NotEmpty
    val items: List<@Valid OrderItemRequest>
) {
    fun toCommand(orderItemRequestMapper: OrderItemRequestMapper): CreateOrderCommand {
        return CreateOrderCommand(
            items = items.map { orderItemRequestMapper.toCommand(it) }
        )
    }
}