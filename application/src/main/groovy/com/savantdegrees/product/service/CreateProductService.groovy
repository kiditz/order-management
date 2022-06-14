package com.savantdegrees.product.service


import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.CreateProductUseCase
import com.savantdegrees.product.port.output.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.validation.ValidationException

@Service
class CreateProductService implements CreateProductUseCase {
	@Autowired
	ProductRepository productRepository

	@Override
	Product createProduct(CreateProductRequest request) {
		if (productRepository.existsByCode(request.code))
			throw new ValidationException("Product ${request.code} is already exists")

		def product = request.toProduct()
		productRepository.create(product)
		return product
	}
}
