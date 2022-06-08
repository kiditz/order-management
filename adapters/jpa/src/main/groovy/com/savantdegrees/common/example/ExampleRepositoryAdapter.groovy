package com.savantdegrees.common.example


import com.savantdegrees.common.JpaRepositoryAdapter
import org.springframework.stereotype.Service

@Service
class ExampleRepositoryAdapter extends JpaRepositoryAdapter<ExampleEntity, Example> implements ExampleRepository {
	ExampleRepositoryAdapter(ExampleJpaRepository repo, ExampleMapper mapper) {
		super(repo, mapper)
	}
}