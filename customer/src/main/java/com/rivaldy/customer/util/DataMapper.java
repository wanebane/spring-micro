package com.rivaldy.customer.util;

import com.rivaldy.customer.dto.CustomerResponse;
import com.rivaldy.customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DataMapper {

    private final FormatDate formatDate;

    public CustomerResponse toCustomerRes(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId().toString())
                .email(customer.getEmail())
                .fullName(customer.getFirstName() + " " + customer.getLastName())
                .createdAt(formatDate.convertLocalDateToString(customer.getCreatedAt()))
                .build();
    }

    public List<CustomerResponse> toCustomerListRes(List<Customer> customers){
        return customers.stream()
                .map(this::toCustomerRes)
                .collect(Collectors.toList());
    }
}
