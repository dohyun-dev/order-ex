package com.dohyundev.orderex.order.command.entity

import com.github.f4b6a3.tsid.TsidCreator
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type")
abstract class Payment(
    @Id
    val id: Long = TsidCreator.getTsid256().toLong(),

    var amount: Long = 0L,

    @Enumerated(EnumType.STRING)
    var status: PaymentStatus = PaymentStatus.PENDING,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null,

    var paymentAt: LocalDateTime? = null,
) {
    fun complete() {
        status = PaymentStatus.COMPLETED
        paymentAt = LocalDateTime.now()
    }

    fun fail() {
        status = PaymentStatus.FAILED
    }

    fun refund() {
        status = PaymentStatus.REFUNDED
    }
}

