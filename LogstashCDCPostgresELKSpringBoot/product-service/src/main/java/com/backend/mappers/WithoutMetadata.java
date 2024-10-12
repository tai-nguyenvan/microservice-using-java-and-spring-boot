package com.backend.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "version", ignore = true)
@Mapping(target = "createdBy", ignore = true)
@Mapping(target = "createdAt", ignore = true)
@Mapping(target = "updatedBy", ignore = true)
@Mapping(target = "updatedAt", ignore = true)
@Mapping(target = "id", ignore = true)
public @interface WithoutMetadata {
}
