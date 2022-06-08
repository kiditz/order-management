package com.savantdegrees.order

import com.savantdegrees.common.JpaMapper
import com.savantdegrees.domain.order.OrderLine
import org.mapstruct.Mapper

@Mapper(config = JpaMapper)
interface OrderLineMapper extends JpaMapper<OrderLineEntity, OrderLine> {
}
