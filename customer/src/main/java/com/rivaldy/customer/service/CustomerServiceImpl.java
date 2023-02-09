package com.rivaldy.customer.service;

import com.rivaldy.customer.dto.CustomerRegistrationRequest;
import com.rivaldy.customer.entity.Customer;
import com.rivaldy.customer.repository.CustomerRepository;
import com.rivaldy.customer.exception.CustomerAlreadyExistsException;
import com.rivaldy.customer.exception.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomer {

    private final CustomerRepository repository;

    @Override
    public Customer registerCustomer(CustomerRegistrationRequest request) {
        Boolean isExists = repository.checkExistsCustomerEmail(request.getEmail());
        if(isExists){
            throw new CustomerAlreadyExistsException("Customer with email "+request.getEmail()+" already exists");
        }

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(String customerId) {
        return repository.findCustomerById(Long.valueOf(customerId))
                .orElseThrow(() -> new CustomerNotFoundException("customer "+customerId+" is not found!"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
