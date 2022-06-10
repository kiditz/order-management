package com.savantdegrees

import com.fasterxml.jackson.databind.ObjectMapper
import com.savantdegrees.order.port.input.CreateOrderUseCase
import net.datafaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

class BaseTest extends Specification {
	@Autowired
	MockMvc mockMvc
	static Faker faker = new Faker()

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static List<CreateOrderUseCase.OrderLineCommand> oneLine() {
		return generateLines(1)
	}

	static List<CreateOrderUseCase.OrderLineCommand> twoLines() {
		return generateLines(2)
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
