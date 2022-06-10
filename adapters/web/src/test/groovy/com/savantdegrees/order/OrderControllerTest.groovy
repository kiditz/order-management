package com.savantdegrees.order

import com.savantdegrees.BaseTest
import com.savantdegrees.order.port.input.CreateOrderUseCase
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType

import static org.mockito.ArgumentMatchers.any
import static org.mockito.BDDMockito.given
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [OrderController])
class OrderControllerTest extends BaseTest {
	@MockBean
	private CreateOrderUseCase useCase

	def "when create order then save it"() {
		given:
			def request = new CreateOrderUseCase.CreateOrderRequest(
					lines : twoLines()
			)
		expect:
			given(useCase.createOrder(any())).willReturn(request.toOrder())
			mockMvc.perform(post("/order")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(asJsonString(request)))
					.andDo(print())
					.andExpect(status().isOk())

	}
}
