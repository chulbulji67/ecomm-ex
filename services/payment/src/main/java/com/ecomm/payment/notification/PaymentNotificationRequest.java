package com.ecomm.payment.notification;

import com.ecomm.payment.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotificationRequest {
    String orderReference;
    BigDecimal amount;

    PaymentMethod paymentMethod;

    String customerFirstName;

    String customerLastName;

    String customerEmail;
}
