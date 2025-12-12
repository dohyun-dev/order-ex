package com.dohyundev.orderex.order.command.domain

import com.dohyundev.orderex.order.command.domain.entity.Order
import com.dohyundev.orderex.order.command.domain.entity.OrderItem

class OrderFactory {
    companion object {
        fun createOrder(
            items: List<OrderItem>
        ): Order {
            val newOrder = Order()
            items.forEach { newOrder.addItem(it) }
            return newOrder
        }
    }
}