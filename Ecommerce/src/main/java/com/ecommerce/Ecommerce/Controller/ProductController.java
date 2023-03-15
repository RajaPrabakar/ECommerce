package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.ProductRequestDTO;
import com.ecommerce.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Validated
@RestController
public class ProductController
{

    @Autowired
    private ProductService productService;



    @PostMapping(value = "/add-product")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO)
    {
        Object obj = productService.postProducts(productRequestDTO);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(value = "/update-product-quantity/{id}")
    public ResponseEntity<Object> updateQuantity(@Valid @PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO)
    {
        Object obj = productService.updateProduct(productRequestDTO,id);
        return ResponseEntity.ok(obj);
    }
}
