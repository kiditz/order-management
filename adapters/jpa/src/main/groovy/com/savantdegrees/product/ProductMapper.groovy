package com.savantdegrees.product

import com.savantdegrees.common.JpaMapper
import com.savantdegrees.domain.product.Product
import org.mapstruct.Mapper

@Mapper(config = JpaMapper)
interface ProductMapper extends JpaMapper<ProductEntity, Product> {
}
