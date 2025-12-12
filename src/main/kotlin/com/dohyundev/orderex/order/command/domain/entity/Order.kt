package com.dohyundev.orderex.order.command.domain.entity

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
        require(status == OrderStatus.PENDING) {
            "주문이 확정된 이후에는 상품을 추가할 수 없습니다"
        }
        items.add(item)
        item.order = this
        recalculateTotalAmount()
    }

    fun addPayment(payment: Payment) {
        require(status == OrderStatus.PENDING) {
            "주문이 완료된 이후에는 결제를 추가할 수 없습니다"
        }
        payments.add(payment)
    }

    fun cancel() {
        status = status.cancel(this)
    }

    fun complete() {
        status = status.complete(this)
    }

    internal fun validatePaymentCompleted() {
        val totalPaidAmount = payments
            .filter { it.status == PaymentStatus.COMPLETED }
            .sumOf { it.amount }

        if (totalPaidAmount < totalAmount) {
            throw IllegalStateException(
                "결제 금액이 부족합니다. 필요: $totalAmount, 결제됨: $totalPaidAmount"
            )
        }
    }

    private fun recalculateTotalAmount() {
        totalAmount = items.sumOf { it.getTotalPrice() }
    }
}

