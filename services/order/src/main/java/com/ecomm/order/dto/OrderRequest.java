package com.ecomm.order.dto;

import com.ecomm.order.entity.PaymentMethod;
import com.ecomm.order.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderRequest {

    private Integer id;
    private String reference;

    @Positive(message = "Order amount should be positive")
    private BigDecimal amount;

    @NotNull(message = "Payment Method should be precised")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    String customerId;

    @NotEmpty(message = "You should at least purchase one product ")
    List<PurchaseRequest> products;
}
