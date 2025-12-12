package com.dohyundev.orderex.order.command.domain.entity

import java.time.LocalDateTime

enum class PaymentStatus {
    PENDING {
        override fun complete(payment: Payment): PaymentStatus {
            payment.paymentAt = LocalDateTime.now()
            return COMPLETED
        }

        override fun refund(payment: Payment): PaymentStatus =
            throw IllegalStateException("완료되지 않은 결제는 취소할 수 없습니다")

        override fun fail(payment: Payment): PaymentStatus =
            FAILED
    },

    COMPLETED {
        override fun complete(payment: Payment): PaymentStatus =
            throw IllegalStateException("이미 완료된 결제입니다")

        override fun refund(payment: Payment): PaymentStatus {
            payment.refundedAt = LocalDateTime.now()
            return REFUNDED
        }

        override fun fail(payment: Payment): PaymentStatus =
            throw IllegalStateException("완료된 결제는 실패시킬 수 없습니다")
    },

    FAILED {
        override fun complete(payment: Payment): PaymentStatus =
            throw IllegalStateException("실패한 결제는 완료할 수 없습니다")

        override fun refund(payment: Payment): PaymentStatus =
            throw IllegalStateException("실패한 결제는 취소할 수 없습니다")

        override fun fail(payment: Payment): PaymentStatus =
            throw IllegalStateException("이미 실패한 결제입니다")
    },

    REFUNDED {
        override fun complete(payment: Payment): PaymentStatus =
            throw IllegalStateException("취소된 결제는 완료할 수 없습니다")

        override fun refund(payment: Payment): PaymentStatus =
            throw IllegalStateException("이미 취소된 결제입니다")

        override fun fail(payment: Payment): PaymentStatus =
            throw IllegalStateException("취소된 결제는 실패시킬 수 없습니다")
    };

    open fun complete(payment: Payment): PaymentStatus =
        throw UnsupportedOperationException()

    open fun refund(payment: Payment): PaymentStatus =
        throw UnsupportedOperationException()

    open fun fail(payment: Payment): PaymentStatus =
        throw UnsupportedOperationException()
}