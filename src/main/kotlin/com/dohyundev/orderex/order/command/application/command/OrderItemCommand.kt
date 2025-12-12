package com.dohyundev.orderex.order.command.application.command

import com.dohyundev.orderex.order.command.domain.entity.OrderItem

data class OrderItemCommand(
    val productId: Long,
    val quantity: Int,
    val price: Long
) {
    fun toEntity(): OrderItem {
        return OrderItem(
            productId = productId,
            quantity = quantity,
            price = price,
        )
    }
}
