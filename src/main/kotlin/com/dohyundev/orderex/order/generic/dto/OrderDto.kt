package com.dohyundev.orderex.order.generic.dto

import com.dohyundev.orderex.order.command.entity.OrderStatus
import com.github.f4b6a3.tsid.TsidCreator
import java.io.Serializable

/**
 * DTO for {@link com.dohyundev.orderex.order.command.entity.Order}
 */
data class OrderDto(
    val id: Long = TsidCreator.getTsid256().toLong(),
    val items: MutableList<OrderItemDto> = mutableListOf(),
    val payments: MutableList<PaymentDto> = mutableListOf(),
    val totalAmount: Long = 0,
    val status: OrderStatus = OrderStatus.PENDING
) : Serializable