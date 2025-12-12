package com.dohyundev.orderex.order.command.ui.mapper

import com.dohyundev.orderex.order.command.application.command.OrderItemCommand
import com.dohyundev.orderex.order.command.ui.dto.OrderItemRequest
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface OrderRequestMapper {
    fun toCommand(request: OrderItemRequest): OrderItemCommand
}