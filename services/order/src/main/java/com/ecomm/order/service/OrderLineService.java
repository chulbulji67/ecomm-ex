package com.ecomm.order.service;

import com.ecomm.order.dto.OrderLineResponse;
import com.ecomm.order.entity.Order;
import com.ecomm.order.exception.EntityNotFound;
import com.ecomm.order.mapper.OrderLineMapper;
import com.ecomm.order.orderline.OrderLine;
import com.ecomm.order.orderline.OrderLineRequest;
import com.ecomm.order.repository.OrderLineRepository;
import com.ecomm.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper mapper;

    private final OrderRepository orderRepository;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {

//   return orderLineRepository.save(mapper.toOrderLine(orderLineRequest)).getId();
        Order order = orderRepository.findById(orderLineRequest.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderLine orderLine = mapper.toOrderLine(orderLineRequest);
        orderLine.setOrder(order);   // ✅ managed entity

        return orderLineRepository.save(orderLine).getId();

    }

    public List<OrderLineResponse> findAllOrderLine(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId).stream().map(mapper::fromOrder).toList();
    }
}
