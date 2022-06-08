package com.savantdegrees.common

import com.savantdegrees.domain.BaseDomain
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional

@NoRepositoryBean
interface BaseMongoRepository<E extends BaseDomain> extends MongoRepository<E, UUID> {
	static final String SELECT_NOT_DELETED = "{'deleted' : false, 'id': ?0 }"

	@Query(SELECT_NOT_DELETED)
	@Transactional(readOnly = true)
	Optional<E> getToUpdateById(UUID id)


	@Query(SELECT_NOT_DELETED)
	@Transactional(readOnly = true)
	Optional<E> getToDeleteById(UUID id);
}
