package com.backend.apis;

import com.backend.dtos.product.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductApiController extends BaseController {

    @RequestMapping(path = "/api/v1/product/search"
            , method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> search() {
        return ResponseEntity.ok().body(productApiService.search());
    }

}
