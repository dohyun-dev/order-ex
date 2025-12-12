package com.dohyundev.orderex.order.command.ui.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.PositiveOrZero

data class OrderItemRequest(
    val productId: Long,

    @field:Min(value = 1, message = "수량은 최소 1개 이상이어야 합니다")
    val quantity: Int,

    @field:PositiveOrZero(message = "가격은 0 이상이어야 합니다")
    val price: Long
)
