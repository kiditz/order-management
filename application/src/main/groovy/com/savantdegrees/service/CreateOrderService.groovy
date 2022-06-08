package com.savantdegrees.service

import com.savantdegrees.common.UseCase
import com.savantdegrees.domain.order.Order
import com.savantdegrees.port.input.CreateOrderUseCase
import com.savantdegrees.port.output.OrderRepository
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired

import javax.transaction.Transactional
import javax.validation.ValidationException

@UseCase
class CreateOrderService implements CreateOrderUseCase {
	@Autowired
	OrderRepository orderRepository
	@Autowired
	ProductRepository productRepository

	@Transactional
	@Override
	Order createOrder(CreateOrderRequest command) {
		def order = command.toOrder()
		for (def line : order.lines) {
			if (!productRepository.existsById(line.productId)) {
				throw new ValidationException("Product ${line.productId} not found")
			}
		}
		orderRepository.create(order)
		return order
	}
}
