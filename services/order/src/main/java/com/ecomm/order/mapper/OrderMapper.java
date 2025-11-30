package com.ecomm.order.mapper;

import com.ecomm.order.dto.OrderRequest;
import com.ecomm.order.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {


    public Order toOrder(OrderRequest request) {

        return Order.builder()
                .id(request.getId())
                .customerId(request.getCustomerId())
                .reference(request.getReference())
                .totalAmount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .build();
    }
}
