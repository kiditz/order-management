package com.savantdegrees.order

import com.savantdegrees.common.Adapter
import com.savantdegrees.common.MongoRepositoryAdapter
import com.savantdegrees.domain.order.Order
import com.savantdegrees.port.output.OrderRepository

@Adapter
class OrderRepositoryAdapter extends MongoRepositoryAdapter<Order> implements OrderRepository {
	OrderRepositoryAdapter(OrderMongoRepository repo, OrderMapper mapper) {
		super(repo, mapper)
	}
}
