package com.ecomm.payment.service;

import com.ecomm.payment.dto.PaymentRequest;
import com.ecomm.payment.entity.Payment;
import com.ecomm.payment.mapper.PaymentMapper;
import com.ecomm.payment.notification.NotificationProducer;
import com.ecomm.payment.notification.PaymentNotificationRequest;
import com.ecomm.payment.repo.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {

        Payment payment = paymentRepository.save(PaymentMapper.toPayment(request));

        notificationProducer.sendNotification(new PaymentNotificationRequest(
                request.getOrderReference(),
                request.getAmount(),
                request.getPaymentMethod(),
                request.getCustomer().getFirstName(),
                request.getCustomer().getLastName(),
                request.getCustomer().getEmail()
        ));
        return  payment.getId();
    }
}
