package com.savantdegrees

import net.datafaker.Faker
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers
import spock.lang.Specification

@SpringBootTest
@Testcontainers
//@DataJpaTest
class BaseTest extends Specification {
	static Faker faker = new Faker()
}
