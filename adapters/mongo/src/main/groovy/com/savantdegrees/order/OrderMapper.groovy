package com.savantdegrees.order

import com.savantdegrees.common.MongoMapper
import com.savantdegrees.domain.order.Order
import org.mapstruct.Mapper

@Mapper(config = MongoMapper)
interface OrderMapper extends MongoMapper<Order> {
}
