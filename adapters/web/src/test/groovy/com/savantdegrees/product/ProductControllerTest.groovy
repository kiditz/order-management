package com.savantdegrees.product

import com.savantdegrees.BaseTest
import com.savantdegrees.product.port.input.CreateProductUseCase
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ProductController])
class ProductControllerTest extends BaseTest {

	@MockBean
	CreateProductUseCase useCase

	def "when create product then save product"() {
		given:
			def request = new CreateProductUseCase.CreateProductRequest(code : faker.code().gtin8(),
					name : faker.food().sushi(),
					price : faker.number().numberBetween(10, 99).toBigDecimal())
		expect:
			when(useCase.createProduct(any())).thenReturn(request.toProduct())
			mockMvc.perform(post("/product")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(asJsonString(request)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("\$.code").value(request.code))
	}
}
