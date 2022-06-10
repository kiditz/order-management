package com.savantdegrees

import net.datafaker.Faker
import spock.lang.Specification

class BaseTest extends Specification {
	static def faker = new Faker()
}
