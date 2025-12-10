package com.ecomm.notification.kafka.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentConfirmation {

    String orderReference;
    BigDecimal amount;

    PaymentMethod paymentMethod;

    String customerFirstName;

    String customerLastName;

    String customerEmail;

}
