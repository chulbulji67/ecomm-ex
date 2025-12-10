package com.ecomm.notification.kafka.order;

import com.ecomm.notification.kafka.customer.Customer;
import com.ecomm.notification.kafka.payment.PaymentMethod;
import com.ecomm.notification.kafka.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmation {

    String orderReference;
    BigDecimal totalAmount;

    PaymentMethod payMentMethod;
    Customer customer;

    List<Product> products;


}
