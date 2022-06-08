package com.savantdegrees.order

import com.savantdegrees.common.BaseEntity
import com.savantdegrees.domain.order.OrderStatus

import javax.persistence.*

@Entity
@Table(name = "order_transaction")
class OrderEntity extends BaseEntity {
	@Id
	UUID id

	@ElementCollection(fetch = FetchType.EAGER, targetClass = OrderLineEntity)
	List<OrderLineEntity> lines
	@Enumerated
	OrderStatus status
	BigDecimal total
}
