package com.savantdegrees.common

import com.savantdegrees.common.example.Example
import com.savantdegrees.common.example.ExampleRepository
import org.springframework.beans.factory.annotation.Autowired

class MongoRepositoryAdapterTest extends BaseTest {
	def dummy = Example.builder()
			.id(UUID.randomUUID())
			.author(faker.book().author())
			.title(faker.book().title())
			.build()

	@Autowired
	ExampleRepository exampleRepository

	def setup() {
		exampleRepository.create(dummy)
	}

	def "when create then save data"() {
		given:
			def example = Example.builder()
					.id(UUID.randomUUID())
					.author(faker.book().author())
					.title(faker.book().title())
					.build()
		when:
			def result = exampleRepository.create(example)
		then:
			example.id == result.id
	}

	def "when update then save data"() {
		given:
			def example = Example.builder()
					.author(faker.book().author())
					.title(faker.book().title())
					.build()
		when:
			def result = exampleRepository.update(dummy.id, example).orElse(null)
		then:
			result != null
			result.title == example.title
	}

	def "when find by id and data found then return product present"() {
		when:
			def result = exampleRepository.findById(dummy.id)
		then:
			result.isPresent()
	}

	def "when find by id and data not found then return product not present"() {
		when:
			def result = exampleRepository.findById(UUID.randomUUID())
		then:
			!result.isPresent()
	}

	def "when exists by id and data found then return true"() {
		when:
			def result = exampleRepository.existsById(dummy.id)
		then:
			result

	}

	def "when exists by id and data not found then return true"() {
		when:
			def result = exampleRepository.existsById(UUID.randomUUID())
		then:
			!result

	}

	def "when delete existing data then return true"() {
		when:
			def result = exampleRepository.delete(dummy.id)
		then:
			result
	}

	def "when delete but data not found return false"() {
		when:
			def result = exampleRepository.delete(UUID.randomUUID())
		then:
			!result
	}

	def "when force delete existing data then return true"() {
		when:
			def result = exampleRepository.forceDelete(dummy.id)
		then:
			!result
	}

	def "when force delete but data not found return false"() {
		when:
			def result = exampleRepository.forceDelete(UUID.randomUUID())
		then:
			!result
	}
//
//	def "test delete"() {
//		given:
//
//		when:
//			// TODO implement stimulus
//		then:
//			// TODO implement assertions
//	}
}
