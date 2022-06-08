package com.savantdegrees.common


import com.savantdegrees.domain.BaseDomain

abstract class MongoRepositoryAdapter<D extends BaseDomain> implements RepositoryPort<D> {
	private final BaseMongoRepository<D> repo
	private final MongoMapper<D> mapper

	MongoRepositoryAdapter(BaseMongoRepository<D> repo, MongoMapper<D> mapper) {
		this.repo = repo
		this.mapper = mapper
	}

	@Override
	D create(D source) {
		return repo.save(source)
	}

	@Override
	Optional<D> update(UUID id, D source) {
		repo.getToUpdateById(id).map { target ->
			D entity = mapper.toUpdate(source, target)
			return entity
		}
	}

	@Override
	Optional<D> findById(UUID id) {
		return repo.findById(id)
	}

	@Override
	boolean existsById(UUID id) {
		return repo.existsById(id)
	}

	@Override
	boolean forceDelete(UUID id) {
		return repo.deleteById(id)
	}

	@Override
	boolean delete(UUID id) {
		repo.getToDeleteById(id).map {
			it.deleted = false
			true
		}.orElse(false)
	}
}
