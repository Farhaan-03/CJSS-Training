package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerModel> getAllCustomers() {

        List<CustomerEntity> customerEntities=  customerRepository.findAll();
        return CustomBeanUtils.convertListOfCustomersToModels(customerEntities);
    }

    public CustomerEntity getCustomerById(int customerId) {
        return customerRepository.findById(customerId).get();
    }

    public CustomerEntity getCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName).orElse(null);

    }
    public CustomerModel getCustomerModelByName(String customerName) {
        CustomerEntity customerEntity= customerRepository.findByCustomerName(customerName).orElse(null);
        if (customerEntity!=null){
            return CustomBeanUtils.convertCustomerEntityToModel(customerEntity);
        }
        return null;

    }

    @Override
    public void saveCustomer(CustomerModel customerModel) {
        CustomerEntity customerEntity=CustomBeanUtils.convertCustomerModelToEntity(customerModel);
        customerRepository.save(customerEntity);
    }
}
