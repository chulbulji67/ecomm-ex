package com.ecomm.order.controller;

import com.ecomm.order.dto.OrderLineResponse;
import com.ecomm.order.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{order-line}")
    private ResponseEntity<List<OrderLineResponse>> getOrderLines(@PathVariable("order-id") Integer orderId){

        return ResponseEntity.ok().body(orderLineService.findAllOrderLine(orderId));

    }
}
