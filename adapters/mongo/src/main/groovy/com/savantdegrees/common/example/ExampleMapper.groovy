package com.savantdegrees.common.example


import com.savantdegrees.common.MongoMapper
import org.mapstruct.Mapper

@Mapper(config = MongoMapper)
interface ExampleMapper extends MongoMapper<Example> {
}
