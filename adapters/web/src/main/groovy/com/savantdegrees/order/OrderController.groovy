package com.savantdegrees.order

import com.savantdegrees.domain.order.Order
import com.savantdegrees.port.input.CreateOrderUseCase
import com.savantdegrees.port.input.CreateOrderUseCase.CreateOrderRequest
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("/order")
@Validated
@Tag(name = "Order")
class OrderController {
	@Autowired
	private CreateOrderUseCase createOrder

	@PostMapping
	Order createOrder(@RequestBody @Valid CreateOrderRequest command) {
		createOrder.createOrder command
	}
}
