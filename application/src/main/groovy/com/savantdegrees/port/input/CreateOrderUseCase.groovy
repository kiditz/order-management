package com.savantdegrees.port.input

import com.savantdegrees.domain.order.Order
import com.savantdegrees.domain.order.OrderLine

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

interface CreateOrderUseCase {
	Order createOrder(CreateOrderRequest command)

	class CreateOrderRequest {
		@NotEmpty
		List<OrderLineCommand> lines

		Order toOrder() {
			return new Order(lines.collect { it.toOrderLine() })
		}
	}

	class OrderLineCommand {
		@NotNull
		UUID productId
		@NotNull
		@Min(1L)
		BigDecimal price
		@NotNull
		@Min(1L)
		int quantity

		OrderLine toOrderLine() {
			new OrderLine(
					productId : productId,
					price : price,
					quantity : quantity
			)
		}

	}
}
