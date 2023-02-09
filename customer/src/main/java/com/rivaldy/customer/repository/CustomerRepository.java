package com.rivaldy.customer.repository;

import com.rivaldy.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long customerId);

    @Query("SELECT CASE WHEN COUNT(s) > 0 " +
            "THEN TRUE ELSE FALSE END " +
            "FROM Customer s " +
            "WHERE s.email = :email")
    Boolean checkExistsCustomerEmail(String email);
}
