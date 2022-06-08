package com.savantdegrees.product

import com.savantdegrees.common.MongoMapper
import com.savantdegrees.domain.product.Product
import org.mapstruct.Mapper

@Mapper(config = MongoMapper)
interface ProductMapper extends MongoMapper<Product> {
}
