package com.ecomm.order.payment;

import com.ecomm.order.customer.CustomerResponse;
import com.ecomm.order.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class PaymentRequest {

    BigDecimal amount;
    private PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;

    CustomerResponse customer;

}