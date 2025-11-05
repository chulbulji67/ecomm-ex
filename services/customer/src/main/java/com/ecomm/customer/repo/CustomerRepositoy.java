package com.ecomm.customer.repo;

import com.ecomm.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoy extends MongoRepository<Customer, String> {
}
