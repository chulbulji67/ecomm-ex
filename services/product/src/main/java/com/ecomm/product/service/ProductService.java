package com.ecomm.product.service;

import com.ecomm.product.dto.ProductPurchaseRequest;
import com.ecomm.product.dto.ProductPurchaseResponse;
import com.ecomm.product.dto.ProductRequest;
import com.ecomm.product.dto.ProductResponse;
import com.ecomm.product.exception.ProductNotFound;
import com.ecomm.product.mapper.ProductMapper;
import com.ecomm.product.product.Product;
import com.ecomm.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests) {



    }

    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse).orElseThrow(()->new ProductNotFound("Product Not Found with given Id "+productId));
    }

    public List<ProductResponse> findAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
