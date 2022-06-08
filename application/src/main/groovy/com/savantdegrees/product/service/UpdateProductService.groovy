package com.savantdegrees.product.service

import com.savantdegrees.common.UseCase
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.UpdateProductUseCase
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired

import javax.transaction.Transactional
import javax.validation.ValidationException

@UseCase
class UpdateProductService implements UpdateProductUseCase {
	@Autowired
	ProductRepository productRepository

	@Override
	@Transactional
	Product updateProduct(UpdateProductRequest request) {
		def product = request.toProduct()
		def result = productRepository.update(product.id, product).orElseThrow {
			new ValidationException("Product ${request.id} not found")
		}
		return result
	}
}
