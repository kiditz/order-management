package com.savantdegrees.common

import javax.persistence.MappedSuperclass

@MappedSuperclass
class BaseEntity {
	boolean deleted = false
}