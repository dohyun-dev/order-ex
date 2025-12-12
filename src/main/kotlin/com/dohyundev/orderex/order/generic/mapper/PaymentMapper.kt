package com.dohyundev.orderex.order.generic.mapper

import com.dohyundev.orderex.order.command.domain.entity.Payment
import com.dohyundev.orderex.order.generic.dto.PaymentDto
import org.springframework.stereotype.Component

@Component
class PaymentMapper {

    fun toDto(payment: Payment): PaymentDto {
        return PaymentDto(
            id = payment.id,
            amount = payment.amount,
            status = payment.status,
            paymentAt = payment.paymentAt
        )
    }

    fun toDtoList(payments: List<Payment>): List<PaymentDto> {
        return payments.map { toDto(it) }
    }
}
