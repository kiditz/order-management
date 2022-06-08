package com.savantdegrees

import com.savantdegrees.domain.order.OrderLine
import net.datafaker.Faker

class Dummy {
	static Faker faker = new Faker()
	static List<OrderLine> oneLine() {
		return generateLines(1)
	}
	static List<OrderLine> twoLines() {
		return generateLines(2)
	}

	static List<OrderLine> generateLines(int total) {
		List<OrderLine> lines = []
		for (i in 0..<total) {
			lines.add(new OrderLine(
					productId : UUID.randomUUID(),
					price : faker.number().numberBetween(1, 20).toBigDecimal(),
					quantity : faker.number().numberBetween(1, 5).toInteger()
			))
		}
		return lines
	}
}
