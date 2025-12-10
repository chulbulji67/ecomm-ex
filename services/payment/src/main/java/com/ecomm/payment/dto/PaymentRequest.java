package com.ecomm.payment.dto;

import com.ecomm.payment.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {

    private Integer id;
    BigDecimal amount;
    private PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;

    Customer customer;

}
