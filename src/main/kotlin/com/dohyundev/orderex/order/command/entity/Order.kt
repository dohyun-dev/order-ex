package com.dohyundev.orderex.order.command.entity

import com.github.f4b6a3.tsid.TsidCreator
import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id
    val id: Long = TsidCreator.getTsid256().toLong(),
) {
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val items: MutableList<OrderItem> = mutableListOf()

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val payments: MutableList<Payment> = mutableListOf()

    var totalAmount: Long = 0

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.PENDING

    fun addItem(item: OrderItem) {
        items.add(item)
        calculateTotalAmount()
    }

    fun addPayment(payment: Payment) {
        payments.add(payment)
    }

    private fun calculateTotalAmount() {
        totalAmount = items.sumOf { it.price * it.quantity }
    }
}

