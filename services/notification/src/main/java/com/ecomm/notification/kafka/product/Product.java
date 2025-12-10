package com.ecomm.notification.kafka.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    Integer productId;
    String name;

    String description;

    BigDecimal price;
    double  quantity;
}
