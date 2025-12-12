package com.dohyundev.orderex.order.query.application

import com.dohyundev.orderex.order.command.exception.OrderNotFoundException
import com.dohyundev.orderex.order.command.domain.repository.OrderRepository
import com.dohyundev.orderex.order.generic.dto.OrderDto
import com.dohyundev.orderex.order.generic.mapper.OrderMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderQueryServiceV1(
    private val orderRepository: OrderRepository,
    private val orderMapper: OrderMapper
) {
    fun getOrder(orderId: Long): OrderDto {
        val order = orderRepository.findByIdOrNull(orderId)
            ?: throw OrderNotFoundException(orderId)

        return orderMapper.toDto(order)
    }
}
