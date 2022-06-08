package com.savantdegrees.product

import com.savantdegrees.BaseTest
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql

@Sql("ProductRepositoryAdapterTest.sql")
@Sql(scripts = "ProductRepositoryAdapterTestClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProductRepositoryAdapterTest extends BaseTest {
	@Autowired
	ProductRepository productRepository

	def "when call exists by code and data found then return true"() {
		given:
			def code = "IP8"
		when:
			def result = productRepository.existsByCode(code)
		then:
			result
	}

	def "when call exists by code and data not found then return false"() {
		given:
			def code = "IP12"
		when:
			def result = productRepository.existsByCode(code)
		then:
			!result
	}
}
