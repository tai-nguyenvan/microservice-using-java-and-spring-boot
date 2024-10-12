package com.backend.apis;

import com.backend.dtos.product.ProductDto;
import com.backend.utils.api.ResponseData;
import com.backend.utils.paging.PaginationUtils;
import com.backend.utils.paging.Paging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductApiController extends BaseController {

    @RequestMapping(path = "/api/v1/product"
            , method = RequestMethod.POST
            , produces = "application/json"
            , consumes = "application/json")
    public ResponseEntity<ResponseData<ProductDto>> addNew(
            @Validated @RequestBody ProductDto dto) {
        return ResponseEntity.ok().body(
                new ResponseData<>(HttpStatus.CREATED.value(), productApiService.addNew(dto))
        );
    }

    @RequestMapping(path = "/api/v1/product"
            , method = RequestMethod.GET
            , produces = "application/json"
            , consumes = "application/json")
    public ResponseEntity<ResponseData<Paging<ProductDto>>> getAll() {
        return ResponseEntity.ok().body(
                new ResponseData<>(HttpStatus.OK.value(), PaginationUtils.generatePage(productApiService.getAll()))
        );
    }

    @RequestMapping(path = "/api/v1/product/{id}"
            , method = RequestMethod.GET
            , produces = "application/json"
            , consumes = "application/json")
    public ResponseEntity<ResponseData<ProductDto>> getDetails(
            @PathVariable String id) {
        return ResponseEntity.ok().body(
                new ResponseData<>(HttpStatus.OK.value(), productApiService.getDetails(id))
        );
    }

//    @RequestMapping(path = "/api/v1/product/{id}"
//            , method = RequestMethod.DELETE
//            , produces = "application/json"
//            , consumes = "application/json")
//    public ResponseEntity<ResponseData<ProductDto>> delete(
//            @PathVariable String id) {
//        return ResponseEntity.ok().body(
//                new ResponseData<>(HttpStatus.OK.value(), productApiService.getDetails(id))
//        );
//    }

}
