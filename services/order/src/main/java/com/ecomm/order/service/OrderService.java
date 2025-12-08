package com.ecomm.order.service;

import com.ecomm.order.customer.CustomerClient;
import com.ecomm.order.customer.CustomerResponse;
import com.ecomm.order.dto.OrderRequest;
import com.ecomm.order.dto.OrderResponse;
import com.ecomm.order.entity.Order;
import com.ecomm.order.exception.BusinessException;
import com.ecomm.order.exception.OrderNotFoundException;
import com.ecomm.order.kafka.OrderConfirmation;
import com.ecomm.order.kafka.OrderProducer;
import com.ecomm.order.mapper.OrderMapper;
import com.ecomm.order.orderline.OrderLineRequest;
import com.ecomm.order.product.PurchaseRequest;
import com.ecomm.order.product.PurchaseResponse;
import com.ecomm.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final CustomerClient customerClient;

    private final com.ecomm.order.product.productClient productClient;

    private final OrderRepository orderRepository;

    private final OrderMapper mapper;

    private final OrderLineService orderLineService;

    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        //check the customer OpenFeign
        CustomerResponse customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(()-> new BusinessException("Can not create Order : Customer Not found with given Id"));


        //purchase the product--> product-ms(RestTemplate
        List<PurchaseResponse> purchaseResponses = this.productClient.purchaseProducts(request.getProducts());

        //persist order.
        Order order = orderRepository.save(mapper.toOrder(request));

        //persist order line

        for(PurchaseRequest purchaseRequest: request.getProducts()){
            orderLineService.saveOrderLine(new OrderLineRequest(null, order.getId(), purchaseRequest.getProductId(), purchaseRequest.getQuantity()));
        }

        //start payment process

        //send the order confirmation->> notification-ms (Kafka)

        orderProducer.sendOrderConfirmation(new OrderConfirmation(
                request.getReference(),
                request.getAmount(),
                request.getPaymentMethod(),
                customer,
                purchaseResponses
        ));

        return order.getId();
    }

    public List<OrderResponse> findAll() {

        return orderRepository.findAll().stream().map(mapper::fromOrder)
                .toList();
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId).map(mapper::fromOrder).orElseThrow(()-> new OrderNotFoundException("Order not found with given id: "+orderId));
    }
}
