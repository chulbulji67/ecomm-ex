package com.ecomm.customer.service;

import com.ecomm.customer.dto.CustomerRequest;
import com.ecomm.customer.dto.CustomerResponse;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.exception.CustomerNodFoundException;
import com.ecomm.customer.mapper.CustomerMapper;
import com.ecomm.customer.repo.CustomerRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepositoy customerRepositoy;

    private final CustomerMapper mapper;


    public String createCustomer(CustomerRequest customerRequest) {
    Customer customer = customerRepositoy.save(mapper.toCustomer(customerRequest));
    return customer.getId();
    }

    public void updateCustomer(CustomerRequest customerRequest) {
        Customer existingCust = customerRepositoy.findById(customerRequest.getId()).orElseThrow(()-> new CustomerNodFoundException("Customer not found with Id "+ customerRequest.getId()));

        mergeCustomer(existingCust, customerRequest);
    }

    private void mergeCustomer(Customer existingCust, CustomerRequest customerRequest) {
        if(!customerRequest.getFirstName().isEmpty()){
            existingCust.setFirstName(customerRequest.getFirstName());
        }
        if(!customerRequest.getLastName().isEmpty()){
            existingCust.setLastName(customerRequest.getLastName());
        }
        if(!customerRequest.getEmail().isEmpty()){
            existingCust.setEmail(customerRequest.getEmail());
        }
        if(customerRequest.getAddress()!=null){
            existingCust.setAddress(customerRequest.getAddress());
        }

    }

    public List<CustomerResponse> findAllCustomer() {
        List<CustomerResponse> customers =  customerRepositoy.findAll()
                                    .stream()
                                    .map(mapper::fromCustomer)
                                    .toList();
        return customers;

    }

    public Boolean isExistById(String customerId) {
        return customerRepositoy.existsById(customerId);

    }

    public CustomerResponse findById(String customerId) {
//        return mapper.fromCustomer(customerRepositoy.findById(customerId).orElseThrow(()-> new CustomerNodFoundException("Customer Not found with the give id "+customerId)));
        return customerRepositoy.findById(customerId).map(mapper::fromCustomer)
                .orElseThrow(()-> new CustomerNodFoundException(format("No Customer found with provided Id"+customerId)));
    }

    public void deleteCustomer(String customerId) {
        customerRepositoy.deleteById(customerId);
    }
}
