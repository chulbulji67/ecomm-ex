package com.ecomm.order.kafka;

import com.ecomm.order.customer.CustomerResponse;
import com.ecomm.order.entity.PaymentMethod;
import com.ecomm.order.product.PurchaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.requests.ProduceResponse;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderConfirmation {

    String orderReference;

    BigDecimal totalAmount;

    PaymentMethod paymentMethod;

    CustomerResponse customer;

    List<PurchaseResponse> purchaseResponses;
}
