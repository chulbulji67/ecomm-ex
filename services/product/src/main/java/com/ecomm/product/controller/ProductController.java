package com.ecomm.product.controller;

import com.ecomm.product.dto.ProductPurchaseRequest;
import com.ecomm.product.dto.ProductPurchaseResponse;
import com.ecomm.product.dto.ProductRequest;
import com.ecomm.product.dto.ProductResponse;
import com.ecomm.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
                @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
                @RequestBody List<ProductPurchaseRequest> requests
    ){
        return ResponseEntity.ok(productService.purchaseProduct(requests));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

}
