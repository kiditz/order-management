package com.savantdegrees.product

import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.input.CreateProductUseCase
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@Validated
@Tag(name = "Product")
class ProductController {
	@Autowired
	private CreateProductUseCase createProduct

	@PostMapping("/product")
	Product createProduct(@RequestBody @Valid CreateProductUseCase.CreateProductRequest request) {
		return createProduct.createProduct(request)
	}
}
