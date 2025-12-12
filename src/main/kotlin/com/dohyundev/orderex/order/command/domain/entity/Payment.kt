package com.dohyundev.orderex.order.command.domain.entity

import com.github.f4b6a3.tsid.TsidCreator
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_method")
abstract class Payment(
    @Id
    val id: Long = TsidCreator.getTsid256().toLong(),

    var amount: Long = 0L,

    @Enumerated(EnumType.STRING)
    var status: PaymentStatus = PaymentStatus.PENDING,

    @Transient
    val method: PaymentMethod
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    lateinit var order: Order

    var paymentAt: LocalDateTime? = null

    var refundedAt: LocalDateTime? = null

    fun fail() {
        status = status.fail(this)
    }

    fun complete() {
        status = status.complete(this)
        paymentAt = LocalDateTime.now()
    }

    fun refund() {
        status = status.refund(this)
    }
}

