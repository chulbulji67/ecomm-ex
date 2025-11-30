package com.ecomm.order.orderline;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderLineRequest {

    private Integer id;
    private Integer orderId;

    private Integer productId;

    private double quantity;
}
