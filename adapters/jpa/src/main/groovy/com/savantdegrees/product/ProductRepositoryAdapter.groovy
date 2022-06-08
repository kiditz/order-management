package com.savantdegrees.product

import com.savantdegrees.common.Adapter
import com.savantdegrees.common.JpaRepositoryAdapter
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.output.ProductRepository

@Adapter
class ProductRepositoryAdapter extends JpaRepositoryAdapter<ProductEntity, Product> implements ProductRepository {
	private final ProductJpaRepository repo

	ProductRepositoryAdapter(ProductJpaRepository repo, ProductMapper mapper) {
		super(repo, mapper)
		this.repo = repo
	}

	@Override
	boolean existsByCode(String code) {
		repo.existsByCode(code)
	}
}
