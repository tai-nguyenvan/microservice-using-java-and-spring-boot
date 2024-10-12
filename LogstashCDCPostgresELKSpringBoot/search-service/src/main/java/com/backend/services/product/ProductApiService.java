package com.backend.services.product;

import com.backend.documents.ProductDocument;
import com.backend.dtos.product.ProductDto;
import com.backend.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductApiService extends BaseService {

    public List<ProductDto> search() {
        List<ProductDocument> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

}
