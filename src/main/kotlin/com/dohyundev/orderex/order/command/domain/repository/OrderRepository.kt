package com.dohyundev.orderex.order.command.domain.repository

import com.dohyundev.orderex.order.command.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>
