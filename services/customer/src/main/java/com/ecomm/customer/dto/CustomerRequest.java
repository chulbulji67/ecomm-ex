package com.ecomm.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import com.ecomm.customer.entity.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest {
    private String id;
    @NotNull(message = "Customer firstname is required")
    private String firstName;
    @NotNull(message = "Customer lastName is required")
    private String lastName;
    @NotNull(message = "Customer email is required")
    @Email(message = "Customer Email is Not Valid Email")
    private String email;
    private Address address;
}
