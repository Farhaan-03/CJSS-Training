package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {


     List<CustomerModel> getAllCustomers();

     CustomerEntity getCustomerById(int customerId);

    CustomerEntity getCustomerByName(String customerName);

    void saveCustomer(CustomerModel customerModel);

    CustomerModel getCustomerModelByName(String customerName);
}

