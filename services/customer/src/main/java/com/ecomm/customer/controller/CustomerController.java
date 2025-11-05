package com.ecomm.customer.controller;

import com.ecomm.customer.dto.CustomerRequest;
import com.ecomm.customer.dto.CustomerResponse;
import com.ecomm.customer.entity.Customer;
import com.ecomm.customer.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.ws.rs.PUT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService customerService){
        service = customerService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return ResponseEntity.ok(service.createCustomer(customerRequest));

    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ){
        service.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAllCustomer());
    }

    @GetMapping("/exists/{customer_id}")
    public ResponseEntity<Boolean> existById(@PathVariable String customer_id){
        return ResponseEntity.ok(service.isExistById(customer_id));
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer_id") String customerId){
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> delete(@PathVariable("customer-id") String customerId){
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }


}
