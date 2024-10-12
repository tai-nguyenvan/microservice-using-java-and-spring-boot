package com.backend.services.product;

import com.backend.dtos.product.ProductDto;
import com.backend.entities.ProductEntity;
import com.backend.mappers.ProductMapper;
import com.backend.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductApiService extends BaseService {

    public ProductDto addNew(ProductDto dto) {
        ProductEntity newEntity = ProductMapper.INSTANCE.toEntity(dto);
        ProductEntity savedEntity = productRepository.save(newEntity);
        return ProductMapper.INSTANCE.toDto(savedEntity);
    }

    public Page<ProductDto> getAll() {
        Page<ProductEntity> entityPage = productRepository.findAll(PageRequest.of(10, 0));
        return entityPage.map(ProductMapper.INSTANCE::toDto);
    }

    public ProductDto getDetails(String id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        return ProductMapper.INSTANCE.toDto(entity);
    }
}
