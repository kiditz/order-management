package com.savantdegrees.common

import javax.transaction.Transactional

/**
 * @author Rifky Aditya Bastara
 * */
@Transactional
abstract class JpaRepositoryAdapter<E extends BaseEntity, D> implements RepositoryPort<D> {

	private final BaseJpaRepository<E> repo

	protected final JpaMapper<E, D> mapper


	JpaRepositoryAdapter(BaseJpaRepository<E> repo, JpaMapper<E, D> mapper) {
		this.repo = repo
		this.mapper = mapper
	}

	@Override
	D create(D source) {
		E entity = mapper.toCreate(source)
		repo.save entity
		return mapper.toModel(entity)
	}


	@Override
	Optional<D> update(UUID id, D source) {
		return repo.getToUpdateById(id).map { target ->
			E entity = mapper.toUpdate(source, target)
			return entity
		}.map { mapper.toModel(it) }
	}

	@Override
	Optional<D> findById(UUID id) {
		return repo.findById(id).map { mapper.toModel(it) }
	}

	@Override
	boolean existsById(UUID id) {
		return repo.existsById(id)
	}

	@Override
	boolean forceDelete(UUID id) {
		repo.getToDeleteById(id).map {
			repo.delete(it)
			return true
		}.orElse(false)
	}

	@Override
	boolean delete(UUID id) {
		return repo.getToDeleteById(id).map {
			it.deleted = true
			return true
		}.orElse(false)
	}

}
