package com.ecomm.order.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PurchaseRequest {

    @NotNull(message = "Product id should be not null")
    private Integer productId;

    @Positive(message = "Quantity should be positive")
    private double quantity;
}
