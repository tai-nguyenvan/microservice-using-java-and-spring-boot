package com.backend.apis;

import com.backend.services.product.ProductApiService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    @Autowired
    protected ProductApiService productApiService;

}
