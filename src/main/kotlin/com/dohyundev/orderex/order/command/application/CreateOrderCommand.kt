package com.dohyundev.orderex.order.command.application

import com.dohyundev.orderex.order.command.application.command.OrderItemCommand

class CreateOrderCommand(
    val items: List<OrderItemCommand> = emptyList()
) {
}
