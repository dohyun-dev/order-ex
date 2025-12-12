package com.dohyundev.orderex.order.command.repository

import com.dohyundev.orderex.order.command.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>
