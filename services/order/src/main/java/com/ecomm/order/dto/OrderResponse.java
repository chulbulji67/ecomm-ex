package com.ecomm.order.dto;

import com.ecomm.order.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    Integer id;
    String reference;

    BigDecimal amount;

    PaymentMethod paymentMethod;

    String customerId;
}
