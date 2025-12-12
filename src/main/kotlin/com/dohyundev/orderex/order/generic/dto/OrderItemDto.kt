package com.dohyundev.orderex.order.generic.dto

import com.github.f4b6a3.tsid.TsidCreator
import java.io.Serializable

/**
 * DTO for {@link com.dohyundev.orderex.order.command.entity.OrderItem}
 */
data class OrderItemDto(
    val id: Long = TsidCreator.getTsid256().toLong(),
    val productId: Long? = null,
    val quantity: Int? = null,
    val price: Long? = null,
    val orderId: Long = TsidCreator.getTsid256().toLong()
) : Serializable