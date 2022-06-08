package com.savantdegrees.common
/**
 * D = Domain
 * */
interface RepositoryPort<D> {
	D create(D source)

	Optional<D> update(UUID id, D source)

	Optional<D> findById(UUID id)

	boolean existsById(UUID id)

	boolean forceDelete(UUID id)

	boolean delete(UUID id)

}