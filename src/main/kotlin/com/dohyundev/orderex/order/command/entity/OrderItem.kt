package com.dohyundev.orderex.order.command.entity

import com.github.f4b6a3.tsid.TsidCreator
import jakarta.persistence.*

@Entity
@Table(name = "order_items")
class OrderItem(
    @Id
    val id: Long = TsidCreator.getTsid256().toLong(),

    val productId: Long,

    var quantity: Int,

    var price: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order,
) {
    fun getTotalPrice(): Long = price * quantity
}