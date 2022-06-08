package com.savantdegrees.product.port.input

import com.savantdegrees.domain.product.Product

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

interface UpdateProductUseCase {
	Product updateProduct(UpdateProductRequest request)

	class UpdateProductRequest {
		@NotNull
		UUID id
		@NotBlank
		String code
		@NotBlank
		String name
		@NotNull
		BigDecimal price
		Product toProduct() {
			return Product.builder()
					.id(id)
					.code(code)
					.name(name)
					.price(price)
					.build()
		}
	}

}