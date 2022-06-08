package com.savantdegrees.product

import com.savantdegrees.domain.product.Product
import com.savantdegrees.common.BaseMongoRepository

interface ProductMongoRepository extends BaseMongoRepository<Product> {
	boolean existsByCode(String code)
}