package com.savantdegrees.product.port.input

import com.savantdegrees.domain.product.Product

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

interface CreateProductUseCase {
	Product createProduct(CreateProductRequest request)

	class CreateProductRequest {
		@NotBlank
		String code
		@NotBlank
		String name
		@Min(1L)
		BigDecimal price

		Product toProduct() {
			return Product.builder()
					.id(UUID.randomUUID())
					.code(code)
					.name(name)
					.price(price)
					.build()
		}
	}
}