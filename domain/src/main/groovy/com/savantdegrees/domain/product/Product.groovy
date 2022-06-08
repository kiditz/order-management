package com.savantdegrees.domain.product

import com.savantdegrees.domain.BaseDomain
import groovy.transform.ToString
import groovy.transform.builder.Builder

@Builder
@ToString
class Product extends BaseDomain {
	UUID id
	String code
	String name
	BigDecimal price
}
