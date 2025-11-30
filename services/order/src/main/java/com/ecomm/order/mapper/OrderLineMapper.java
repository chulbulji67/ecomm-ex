package com.ecomm.order.mapper;

import com.ecomm.order.entity.Order;
import com.ecomm.order.orderline.OrderLine;
import com.ecomm.order.orderline.OrderLineRequest;

public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.getId())
                .order
                        (Order.builder()
                                .id(orderLineRequest.getId())
                                .build())
                .productId(orderLineRequest.getProductId())
                .quantity(orderLineRequest.getQuantity())
                .build();
    }
}
