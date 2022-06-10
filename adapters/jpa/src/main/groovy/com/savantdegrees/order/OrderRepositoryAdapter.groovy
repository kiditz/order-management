package com.savantdegrees.order

import com.savantdegrees.common.JpaMapper
import com.savantdegrees.common.JpaRepositoryAdapter
import com.savantdegrees.common.Adapter
import com.savantdegrees.domain.order.Order
import com.savantdegrees.order.port.output.OrderRepository

@Adapter
class OrderRepositoryAdapter extends JpaRepositoryAdapter<OrderEntity, Order> implements OrderRepository {
	OrderRepositoryAdapter(OrderJpaRepository repo, JpaMapper<OrderEntity, Order> mapper) {
		super(repo, mapper)
	}
}
