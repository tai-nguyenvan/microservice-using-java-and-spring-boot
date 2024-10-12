package com.backend.dtos.product;

import com.backend.documents.ProductDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;

    private String name;

    private String description;

    public ProductDto(ProductDocument productDocument) {
        this.id = productDocument.getId();
        this.name = productDocument.getName();
        this.description = productDocument.getDescription();
    }
}
