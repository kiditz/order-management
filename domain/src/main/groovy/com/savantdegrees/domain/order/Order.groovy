package com.savantdegrees.domain.order

import com.savantdegrees.domain.BaseDomain

class Order extends BaseDomain {
	UUID id
	List<OrderLine> lines
	OrderStatus status
	BigDecimal total

	Order(List<OrderLine> lines) {
		this.id = UUID.randomUUID()
		this.lines = lines
		this.total = totalCost()
		this.status = OrderStatus.CREATED
	}

	BigDecimal totalCost() {
		calculateTotalCost()
	}

	private BigDecimal calculateTotalCost() {
		return this.lines.stream()
				.map(OrderLine::cost)
				.reduce((a, b) -> a + b)
				.get()
	}

	@Override
	public String toString() {
		return "Order{" +
				"lines=" + lines +
				", status=" + status +
				", total=" + total +
				'}';
	}
}
