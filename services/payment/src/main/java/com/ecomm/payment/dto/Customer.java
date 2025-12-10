package com.ecomm.payment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    String id;
    @NotNull(message = "First Name is required")
    String firstName;
    @NotNull(message = "Last Name is required")
    String lastName;
    @NotNull(message = "Email is required")
    @Email(message = "The customer email is not correctly formatted")
    String email;

}
