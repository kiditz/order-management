package com.savantdegrees.product.port.input

import com.savantdegrees.domain.product.Product

interface CreateProductUseCase {
	Product createProduct(CreateProductRequest request)

	class CreateProductRequest {
		String code
		String name
		BigDecimal price

		Product toProduct() {
			return new Product(
					id : UUID.randomUUID(),
					code : code,
					name : name,
					price : price
			)
		}
	}

}