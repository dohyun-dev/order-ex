package com.dohyundev.orderex.order.command.ui.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty

class CreateOrderItemRequest(
    @NotEmpty
    val items: List<@Valid OrderItemRequest>
) {
}