package com.savantdegrees.product.service

import com.savantdegrees.common.UseCase
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.CreateProductUseCase
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired

import javax.transaction.Transactional
import javax.validation.ValidationException


@UseCase
class CreateProductService implements CreateProductUseCase {
	@Autowired
	ProductRepository productRepository

	@Transactional
	@Override
	Product createProduct(CreateProductRequest request) {
		if (productRepository.existsByCode(request.code)) {
			throw new ValidationException("Product ${request.code} already exists")
		}
		def product = request.toProduct()
		productRepository.create(product)
		return product
	}
}
