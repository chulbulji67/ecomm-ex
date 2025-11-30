package com.ecomm.product.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPurchaseRequest {

    @NotNull(message = "Product is mandatory")
    private Integer productId;

    @NotNull(message="Qauntity is mandatory")
    private double quantity;
}
