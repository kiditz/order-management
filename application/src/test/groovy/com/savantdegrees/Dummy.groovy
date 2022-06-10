package com.savantdegrees

import com.savantdegrees.order.port.input.CreateOrderUseCase
import net.datafaker.Faker

class Dummy {
	static Faker faker = new Faker()

	static List<CreateOrderUseCase.OrderLineCommand> twoLines() {
		return generateLines(1)
	}

	static List<CreateOrderUseCase.OrderLineCommand> oneLine() {
		return generateLines(1)
	}

	static List<CreateOrderUseCase.OrderLineCommand> generateLines(int total) {
		List<CreateOrderUseCase.OrderLineCommand> lines = []
		for (i in 0..<total) {
			lines.add(new CreateOrderUseCase.OrderLineCommand(
					productId : UUID.randomUUID(),
					price : faker.number().numberBetween(1, 20).toBigDecimal(),
					quantity : faker.number().numberBetween(1, 5).toInteger()
			))
		}
		return lines
	}
}
