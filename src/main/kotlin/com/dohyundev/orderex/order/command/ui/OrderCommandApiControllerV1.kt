package com.dohyundev.orderex.order.command.ui

import com.dohyundev.orderex.order.command.application.OrderCommandServiceV1
import com.dohyundev.orderex.order.command.ui.dto.CreateOrderItemRequest
import com.dohyundev.orderex.order.command.ui.mapper.OrderRequestMapper
import com.dohyundev.orderex.order.generic.dto.OrderDto
import com.dohyundev.orderex.order.query.application.OrderQueryServiceV1
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderCommandApiControllerV1(
    private val orderCommandService: OrderCommandServiceV1,
    private val orderQueryService: OrderQueryServiceV1,
    private val orderRequestMapper: OrderRequestMapper
) {
    @PostMapping
    fun createOrder(
        @Valid @RequestBody request: CreateOrderItemRequest
    ): ResponseEntity<OrderDto> {
        val order = orderCommandService.createOrder()
        return ResponseEntity.status(HttpStatus.CREATED).body(order)
    }

    @PostMapping("/{orderId}/cancel")
    fun cancelOrder(@PathVariable orderId: Long): ResponseEntity<OrderDto> {
        val order = orderCommandService.cancelOrder(orderId)
        return ResponseEntity.ok(order)
    }

    @PostMapping("/{orderId}/complete")
    fun completeOrder(@PathVariable orderId: Long): ResponseEntity<OrderDto> {
        val order = orderCommandService.completeOrder(orderId)
        return ResponseEntity.ok(order)
    }

    @GetMapping("/{orderId}")
    fun getOrder(@PathVariable orderId: Long): ResponseEntity<OrderDto> {
        val order = orderQueryService.getOrder(orderId)
        return ResponseEntity.ok(order)
    }
}