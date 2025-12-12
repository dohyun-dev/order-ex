package com.dohyundev.orderex.order.command.ui.dto

class UpsertOrderItemsRequest {
    val items: MutableList<OrderItemRequest> = mutableListOf()
}