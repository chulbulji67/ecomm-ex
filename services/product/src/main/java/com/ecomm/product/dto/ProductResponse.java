package com.ecomm.product.dto;


import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Builder
@Getter
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
