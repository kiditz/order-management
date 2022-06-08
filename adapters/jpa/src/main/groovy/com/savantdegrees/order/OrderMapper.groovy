package com.savantdegrees.order

import com.savantdegrees.common.JpaMapper
import com.savantdegrees.domain.order.Order
import org.mapstruct.Mapper

@Mapper(config = JpaMapper, uses = OrderLineMapper)
interface OrderMapper extends JpaMapper<OrderEntity, Order> {
}
