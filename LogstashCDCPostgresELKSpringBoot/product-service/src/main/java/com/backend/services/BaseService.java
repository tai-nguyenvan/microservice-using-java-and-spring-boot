package com.backend.services;

import com.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {

    @Autowired
    public ProductRepository productRepository;

}
