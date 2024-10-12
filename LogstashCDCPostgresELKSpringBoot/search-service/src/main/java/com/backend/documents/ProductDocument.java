package com.backend.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
public class ProductDocument {

    @Id
    private String id;

    private String name;

    private String description;

}
