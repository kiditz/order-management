package com.savantdegrees.common

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
interface JpaMapper<E, D> {
	@Mapping(target = "metaClass", ignore = true)
	E toCreate(D request)

	@Mapping(target = "metaClass", ignore = true)
	E toUpdate(D request, @MappingTarget E target)

	@Mapping(target = "metaClass", ignore = true)
	D toModel(E entity)
}