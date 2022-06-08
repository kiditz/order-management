package com.savantdegrees.domain.order

import groovy.transform.builder.Builder

@Builder
class OrderLine {
	UUID productId
	BigDecimal price
	int quantity

	BigDecimal cost() {
		return price * BigDecimal.valueOf(quantity)
	}
}
