package com.dohyundev.orderex.order.command.exception

class OrderNotFoundException(orderId: Long) : RuntimeException("주문을 찾을 수 없습니다: $orderId")
