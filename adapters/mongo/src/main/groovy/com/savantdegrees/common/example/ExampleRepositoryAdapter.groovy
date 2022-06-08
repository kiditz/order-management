package com.savantdegrees.common.example

import com.savantdegrees.common.Adapter
import com.savantdegrees.common.MongoRepositoryAdapter

@Adapter
class ExampleRepositoryAdapter extends MongoRepositoryAdapter<Example> implements ExampleRepository {
	ExampleRepositoryAdapter(ExampleMongoRepository repo, ExampleMapper mapper) {
		super(repo, mapper)
	}
}