package com.savantdegrees.common

import net.datafaker.Faker
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@Testcontainers
abstract class BaseTest extends Specification {
	static Faker faker = new Faker()
	@Shared
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:5.0"))

	@DynamicPropertySource
	static void mongoProps(DynamicPropertyRegistry registry) {
		mongoDBContainer.start()
		registry.add("spring.data.mongodb.uri", () ->   mongoDBContainer.replicaSetUrl)
	}
}
