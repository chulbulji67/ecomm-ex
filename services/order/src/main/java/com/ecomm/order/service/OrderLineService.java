package com.ecomm.order.service;

import com.ecomm.order.mapper.OrderLineMapper;
import com.ecomm.order.orderline.OrderLineRequest;
import com.ecomm.order.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {

   return orderLineRepository.save(mapper.toOrderLine(orderLineRequest)).getId();

    }
}
