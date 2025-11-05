package com.ecomm.customer.dto;

import com.ecomm.customer.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
