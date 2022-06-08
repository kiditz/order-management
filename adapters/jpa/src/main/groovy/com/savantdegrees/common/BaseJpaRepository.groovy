package com.savantdegrees.common

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional

@NoRepositoryBean
interface BaseJpaRepository<E extends BaseEntity> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
	static final String SELECT_NOT_DELETED = "select e from #{#entityName} e where e.deleted = false and e.id=?1"

	@Query(SELECT_NOT_DELETED)
	@Transactional(readOnly = true)
	Optional<E> getToUpdateById(UUID id)

	@Query(SELECT_NOT_DELETED)
	@Transactional(readOnly = true)
	Optional<E> getToDeleteById(UUID id);
}
