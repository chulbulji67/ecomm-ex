package com.ecomm.order.service;

import com.ecomm.order.dto.OrderLineResponse;
import com.ecomm.order.exception.EntityNotFound;
import com.ecomm.order.mapper.OrderLineMapper;
import com.ecomm.order.orderline.OrderLineRequest;
import com.ecomm.order.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {

   return orderLineRepository.save(mapper.toOrderLine(orderLineRequest)).getId();

    }

    public List<OrderLineResponse> findAllOrderLine(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId).stream().map(mapper::fromOrder).toList();
    }
}
