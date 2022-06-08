package com.savantdegrees.common.example


import com.savantdegrees.common.JpaMapper
import org.mapstruct.Mapper

@Mapper(config = JpaMapper)
interface ExampleMapper extends JpaMapper<ExampleEntity, Example> {
}
