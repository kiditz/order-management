package com.savantdegrees.product

import com.savantdegrees.common.Adapter
import com.savantdegrees.common.MongoRepositoryAdapter
import com.savantdegrees.domain.product.Product
import com.savantdegrees.product.port.output.ProductRepository

@Adapter
class ProductRepositoryAdapter extends MongoRepositoryAdapter<Product> implements ProductRepository {
	private ProductMongoRepository repo

	ProductRepositoryAdapter(ProductMongoRepository repo, ProductMapper mapper) {
		super(repo, mapper)
		this.repo = repo
	}

	@Override
	boolean existsByCode(String code) {
		return repo.existsByCode(code)
	}
}
