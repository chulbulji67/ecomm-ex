package com.ecomm.order.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NotNull
@Component
public class PurchaseResponse {
    private Integer productId;

    private String name;
    private String description;
    private BigDecimal price;

    private double quantity;
}
