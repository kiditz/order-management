package com.savantdegrees.product

import com.savantdegrees.common.BaseEntity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
class ProductEntity extends BaseEntity {
	@Id
	UUID id
	String code
	String name
	BigDecimal price
}
