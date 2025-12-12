package com.dohyundev.orderex.order.command.exception

class PaymentNotFoundException(paymentId: Long) : RuntimeException("Payment not found: $paymentId")
