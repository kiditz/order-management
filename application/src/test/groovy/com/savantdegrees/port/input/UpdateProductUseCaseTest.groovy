package com.savantdegrees.port.input

import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.UpdateProductUseCase
import com.savantdegrees.product.port.output.ProductRepository
import com.savantdegrees.product.service.UpdateProductService

import javax.validation.ValidationException

class UpdateProductUseCaseTest extends BaseTest {

	def "when i do update product then save id"() {
		given:
			def product = Product.builder()
					.id(UUID.randomUUID())
					.code(faker.code().gtin8())
					.name(faker.food().sushi())
					.price(BigDecimal.valueOf(faker.number().numberBetween(10, 99)))
					.build()
		and:
			def productRepository = Mock(ProductRepository)
			productRepository.update(product.id, _ as Product) >> Optional.of(product)
		and: "prepare request"
			def request = new UpdateProductUseCase.UpdateProductRequest(
					id : product.id,
					name : product.name,
					code : product.code,
					price : product.price
			)
		when:
			def useCase = new UpdateProductService()
			useCase.productRepository = productRepository
			def result = useCase.updateProduct(request)
		then:
			result.id == product.id

	}

	def "when i do update product but product not found then thrown Validation Exception"() {
		given:
			def product = Product.builder()
					.id(UUID.randomUUID())
					.code(faker.code().gtin8())
					.name(faker.food().sushi())
					.price(BigDecimal.valueOf(faker.number().numberBetween(10, 99)))
					.build()
		and:
			def productRepository = Mock(ProductRepository)
			productRepository.update(product.id, _ as Product) >> Optional.empty()
		and: "prepare request"
			def request = new UpdateProductUseCase.UpdateProductRequest(
					id : product.id,
					name : product.name,
					code : product.code,
					price : product.price
			)
		when:
			def useCase = new UpdateProductService()
			useCase.productRepository = productRepository
			useCase.updateProduct(request)
		then:
			thrown(ValidationException)
	}

}
