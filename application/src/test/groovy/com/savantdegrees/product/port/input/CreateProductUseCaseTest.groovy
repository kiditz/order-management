package com.savantdegrees.product.port.input

import com.savantdegrees.BaseTest
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.CreateProductUseCase
import com.savantdegrees.product.port.output.ProductRepository
import com.savantdegrees.product.service.CreateProductService

import javax.validation.ValidationException

class CreateProductUseCaseTest extends BaseTest {
	def "when create product but product code already exists then thrown validation exception"() {
		given:
			def product = Product.builder()
					.code(faker.code().gtin8())
					.name(faker.food().sushi())
					.price(faker.number().numberBetween(1, 99).toBigDecimal())
					.build()
		and:
			def productRepository = Mock(ProductRepository)
			productRepository.existsByCode(_ as String) >> true
		when:
			def request = new CreateProductUseCase.CreateProductRequest(
					code : product.code,
					name : product.name,
					price : product.price
			)
			def useCase = new CreateProductService()
			useCase.productRepository = productRepository
			useCase.createProduct(request)
		then:
			thrown(ValidationException)
			0 * productRepository.create(_)
	}

	def "when create product then save it"() {
		given:
			def product = Product.builder()
					.code(faker.code().gtin8())
					.name(faker.food().sushi())
					.price(faker.number().numberBetween(1, 99).toBigDecimal())
					.build()
		and:
			def productRepository = Mock(ProductRepository)
			productRepository.existsByCode(_ as String) >> false
		when:
			def request = new CreateProductUseCase.CreateProductRequest(
					code : product.code,
					name : product.name,
					price : product.price
			)
			def useCase = new CreateProductService()
			useCase.productRepository = productRepository
			def result = useCase.createProduct(request)
		then:
			notThrown(ValidationException)
			1 * productRepository.create(_)
			result.code == product.code
	}
}
