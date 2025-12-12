package com.dohyundev.orderex.order.generic.dto

import com.dohyundev.orderex.order.command.domain.entity.PaymentStatus
import com.github.f4b6a3.tsid.TsidCreator
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.dohyundev.orderex.order.command.entity.Payment}
 */
data class PaymentDto(
    val id: Long = TsidCreator.getTsid256().toLong(),
    val amount: Long = 0L,
    val status: PaymentStatus = PaymentStatus.PENDING,
    val orderId: Long = TsidCreator.getTsid256().toLong(),
    val paymentAt: LocalDateTime? = null
) : Serializable