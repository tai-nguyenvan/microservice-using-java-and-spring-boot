package com.backend.mappers;

import com.backend.dtos.product.ProductDto;
import com.backend.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
         unmappedTargetPolicy = ReportingPolicy.IGNORE
         , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
         , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @WithoutMetadata
    ProductEntity toEntity(ProductDto dto);

    ProductDto toDto(ProductEntity entity);

}
