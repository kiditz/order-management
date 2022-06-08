package com.savantdegrees.common

import com.savantdegrees.domain.BaseDomain
import org.mapstruct.MapperConfig
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy

import static org.mapstruct.NullValueCheckStrategy.ALWAYS
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE

@MapperConfig(
		nullValueMappingStrategy = RETURN_DEFAULT,
		nullValueCheckStrategy = ALWAYS,
		nullValuePropertyMappingStrategy = IGNORE,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		componentModel = "spring"
)
interface MongoMapper<D extends BaseDomain> {
	@Mapping(target = "metaClass", ignore = true)
	D toUpdate(D request, @MappingTarget D target)
}