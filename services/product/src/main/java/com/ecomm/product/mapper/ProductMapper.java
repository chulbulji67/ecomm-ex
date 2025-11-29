package com.ecomm.product.mapper;

import com.ecomm.product.dto.ProductRequest;
import com.ecomm.product.dto.ProductResponse;
import com.ecomm.product.product.Category;
import com.ecomm.product.product.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .category(
                        Category.builder()
                                .id(request.getCategoryId())
                                .build()
                )
                .build();

    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .build();
    }
}
