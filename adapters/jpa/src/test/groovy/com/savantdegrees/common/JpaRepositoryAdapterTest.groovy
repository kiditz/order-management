package com.savantdegrees.common

import com.savantdegrees.BaseTest
import com.savantdegrees.common.example.Example
import com.savantdegrees.common.example.ExampleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql

@Sql(value = "ExampleRepositoryTest.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "ExampleRepositoryTestClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class JpaRepositoryAdapterTest extends BaseTest {

	@Autowired
	private ExampleRepository repository

	def "when create then save data"() {
		given:
			def example = Example.builder()
					.id(UUID.randomUUID())
					.title(faker.book().title())
					.author(faker.book().author())
					.build()
		when:
			def result = repository.create(example)
		then:
			result.id == example.id
	}

	def "when update then update data"() {
		given:
			def id = UUID.fromString("42af196b-e32b-4409-b1bf-763b3ea07793")
			def example = Example.builder()
					.id(id)
					.title(faker.book().title())
					.author(faker.book().author())
					.build()
		when:
			def result = repository.update(id, example).orElse(null)
		then:
			result != null
			result.id == id
	}

	def "when find by id and data found then return true"() {
		given:
			def id = UUID.fromString("42af196b-e32b-4409-b1bf-763b3ea07793")
		when:
			def result = repository.findById(id).map((_) -> true).orElse(false)
		then:
			result
	}

	def "when find by id and data not found then return false"() {
		given:
			def id = UUID.randomUUID()
		when:
			def result = repository.findById(id).map((_) -> true).orElse(false)
		then:
			!result
	}

	def "when exists by id called and data found then return true"() {
		given:
			def id = UUID.fromString("42af196b-e32b-4409-b1bf-763b3ea07793")
		when:
			def result = repository.existsById(id)
		then:
			result
	}
//
	def "when force delete and data found then deleted from database and return true"() {
		given:
			def id = UUID.fromString("42af196b-e32b-4409-b1bf-763b3ea07793")
		when:
			def result = repository.forceDelete(id)
		then:
			result
	}

	def "when force delete and data not found then return false"() {
		given:
			def id = UUID.randomUUID()
		when:
			def result = repository.forceDelete(id)
		then:
			!result
	}

	def "when delete and data found then update deleted value to true and return true"() {
		given:
			def id = UUID.fromString("42af196b-e32b-4409-b1bf-763b3ea07793")
		when:
			def result = repository.delete(id)
		then:
			result
	}

	def "when delete and data not found then return false"() {
		given:
			def id = UUID.randomUUID()
		when:
			def result = repository.delete(id)
		then:
			!result
	}
}








