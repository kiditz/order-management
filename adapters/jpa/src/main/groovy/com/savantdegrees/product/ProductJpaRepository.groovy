package com.savantdegrees.product

import com.savantdegrees.common.BaseJpaRepository

interface ProductJpaRepository extends BaseJpaRepository<ProductEntity> {
	boolean existsByCode(String code)
}
