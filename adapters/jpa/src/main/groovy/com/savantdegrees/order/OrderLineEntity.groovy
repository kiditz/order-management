package com.savantdegrees.order

import javax.persistence.Embeddable

@Embeddable
class OrderLineEntity {
	UUID productId
	BigDecimal price
	int quantity
}
