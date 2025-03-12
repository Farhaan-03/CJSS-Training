package com.jspexample.JspExample.controller;

import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/Customers")
    public String getAllCustomers(Model model) {
        List<CustomerModel> customerModels = customerService.getAllCustomers();
        model.addAttribute("customers", customerModels);

        return "customers";
    }
}
