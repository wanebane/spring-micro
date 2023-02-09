package com.rivaldy.customer.service;

import com.rivaldy.customer.dto.CustomerRegistrationRequest;
import com.rivaldy.customer.entity.Customer;

import java.util.List;

public interface ICustomer {

    Customer registerCustomer(CustomerRegistrationRequest request);

    Customer getCustomer(String customerId);

    List<Customer> getAllCustomers();
}
