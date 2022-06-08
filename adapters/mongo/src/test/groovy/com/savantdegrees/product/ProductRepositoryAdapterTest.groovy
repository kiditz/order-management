package com.savantdegrees.product

import com.savantdegrees.common.BaseTest
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired

class ProductRepositoryAdapterTest extends BaseTest {

	@Autowired
	ProductRepository productRepository

	def product = Product.builder()
			.id(UUID.randomUUID())
			.code(faker.code().gtin8())
			.name(faker.food().sushi())
			.price(faker.number().numberBetween(10, 99).toBigDecimal())
			.build()

	def setup() {
		println('Setting up test data...')
		productRepository.create(product)
	}

	void cleanup() {
		productRepository.forceDelete(product.id)
	}

	def "when exists by code and is exists then return true"() {
		when:
			def result = productRepository.existsByCode(product.code)
		then:
			result
	}

	def "when exists by code and is not exists then return false"() {
		when:
			def result = productRepository.existsByCode(faker.code().gtin8())
		then:
			!result
	}
}
