package com.backend.repositories;

import com.backend.documents.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductDocument, String> {

    Iterable<ProductDocument> findAll();
}
