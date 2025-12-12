package com.dohyundev.orderex.order.command.domain.entity

enum class OrderStatus {
    PENDING {
        override fun cancel(order: Order): OrderStatus =
            CANCELLED

        override fun complete(order: Order): OrderStatus {
            order.validatePaymentCompleted()
            return COMPLETED
        }
    },

    COMPLETED {
        override fun cancel(order: Order): OrderStatus =
            throw IllegalStateException("이미 완료된 주문입니다")

        override fun complete(order: Order): OrderStatus =
            throw IllegalStateException("이미 완료된 주문입니다")
    },

    CANCELLED {
        override fun cancel(order: Order): OrderStatus =
            throw IllegalStateException("이미 취소된 주문입니다")

        override fun complete(order: Order): OrderStatus =
            throw IllegalStateException("취소된 주문은 완료할 수 없습니다")
    };

    open fun cancel(order: Order): OrderStatus =
        throw UnsupportedOperationException()

    open fun complete(order: Order): OrderStatus =
        throw UnsupportedOperationException()
}
