package com.ecomm.order.kafka;

import com.ecomm.order.customer.CustomerResponse;
import com.ecomm.order.entity.PaymentMethod;
import com.ecomm.order.product.PurchaseResponse;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.requests.ProduceResponse;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class OrderConfirmation {

    String orderReference;

    BigDecimal totalAmount;

    PaymentMethod paymentMethod;

    CustomerResponse customer;

    List<PurchaseResponse> purchaseResponses;
}
