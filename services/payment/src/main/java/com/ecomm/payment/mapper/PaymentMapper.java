package com.ecomm.payment.mapper;

import com.ecomm.payment.dto.PaymentRequest;
import com.ecomm.payment.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public static Payment toPayment(PaymentRequest request) {

        return Payment.builder()
                .id(request.getId())
                .orderId(request.getOrderId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getAmount())
                .build();
    }
}
