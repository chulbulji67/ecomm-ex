package com.ecomm.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Getter
@Setter
public class ProductRequest {

     Integer id;
     @NotNull(message = "Product name isn required")
     String name;

     @NotNull(message = "Product Description is Required")
     String description;

     @NotNull(message = "Product Quantity must be Greater than one")
     double availableQuantity;

     @NotNull(message = "Price should be positive")
     BigDecimal price;

     @NotNull(message="Category iD is Requird")
    Integer categoryId;
}
