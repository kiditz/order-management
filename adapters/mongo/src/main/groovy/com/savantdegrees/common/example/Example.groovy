package com.savantdegrees.common.example

import com.savantdegrees.domain.BaseDomain
import groovy.transform.builder.Builder

@Builder
class Example extends BaseDomain {
	UUID id
	String title
	String author
}