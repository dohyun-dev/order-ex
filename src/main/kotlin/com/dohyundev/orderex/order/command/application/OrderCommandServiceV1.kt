package com.dohyundev.orderex.order.command.application

import com.dohyundev.orderex.order.command.domain.entity.Order
import com.dohyundev.orderex.order.command.domain.OrderFactory
import com.dohyundev.orderex.order.command.domain.repository.OrderRepository
import com.dohyundev.orderex.order.command.exception.OrderNotFoundException
import com.dohyundev.orderex.order.generic.dto.OrderDto
import com.dohyundev.orderex.order.generic.mapper.OrderMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCommandServiceV1(
    private val orderRepository: OrderRepository,
    private val orderMapper: OrderMapper
) {
    fun createOrder(command: CreateOrderCommand): OrderDto {
        val orderItems = command.items.map { it.toEntity() }

        val newOrder = OrderFactory.createOrder(orderItems)

        val savedOrder = orderRepository.save(newOrder)

        return orderMapper.toDto(savedOrder)
    }

    fun cancelOrder(orderId: Long): OrderDto {
        val order = findOrderEntity(orderId)
        order.cancel()
        return orderMapper.toDto(order)
    }

    fun completeOrder(orderId: Long): OrderDto {
        val order = findOrderEntity(orderId)
        order.complete()
        return orderMapper.toDto(order)
    }

    private fun findOrderEntity(orderId: Long): Order = orderRepository.findByIdOrNull(orderId) ?: throw OrderNotFoundException(orderId)

}