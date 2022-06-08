package com.savantdegrees.product.port.output

import com.savantdegrees.common.RepositoryPort
import com.savantdegrees.domain.product.Product

interface ProductRepository extends RepositoryPort<Product> {
	boolean existsByCode(String code)
}
