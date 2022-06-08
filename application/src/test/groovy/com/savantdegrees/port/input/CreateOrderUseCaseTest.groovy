package com.savantdegrees.port.input

import com.savantdegrees.domain.order.Order
import com.savantdegrees.domain.order.OrderStatus
import com.savantdegrees.port.output.OrderRepository
import com.savantdegrees.product.port.output.ProductRepository
import com.savantdegrees.service.CreateOrderService
import spock.lang.Specification

import javax.validation.ValidationException


class CreateOrderUseCaseTest extends Specification {
	def "when create order then save it"() {
		given:
			def lines = Dummy.twoLines()
		and:
			OrderRepository orderRepo = Mock(OrderRepository)
			ProductRepository productRepo = Mock(ProductRepository)
			productRepo.existsById(_ as UUID) >> true
		and:
			def order = new CreateOrderService()
			order.setOrderRepository(orderRepo)
			order.setProductRepository(productRepo)
		when:
			def res = order.createOrder(new CreateOrderUseCase.CreateOrderRequest(lines : lines))
		then:
			1 * orderRepo.create(_ as Order)
			res.status == OrderStatus.CREATED
	}

	def "when create order but there's not product found then thrown validation exception"() {
		given:
			def lines = Dummy.oneLine()
		and:
			OrderRepository orderRepo = Mock(OrderRepository)
			ProductRepository productRepo = Mock(ProductRepository)
			productRepo.existsById(_ as UUID) >> false
		and:
			def order = new CreateOrderService()
			order.setOrderRepository(orderRepo)
			order.setProductRepository(productRepo)
		when:
			order.createOrder(new CreateOrderUseCase.CreateOrderRequest(lines : lines))
		then:
			thrown ValidationException
	}

}
