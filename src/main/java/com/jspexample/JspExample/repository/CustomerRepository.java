package com.jspexample.JspExample.repository;

import com.jspexample.JspExample.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

    public Optional<CustomerEntity> findByCustomerName(String customerName);
}
