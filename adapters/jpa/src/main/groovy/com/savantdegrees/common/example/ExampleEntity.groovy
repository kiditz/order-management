package com.savantdegrees.common.example

import com.savantdegrees.common.BaseEntity
import org.hibernate.annotations.Type

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "example")
class ExampleEntity extends BaseEntity {
	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
	UUID id
	String title
	String author
}