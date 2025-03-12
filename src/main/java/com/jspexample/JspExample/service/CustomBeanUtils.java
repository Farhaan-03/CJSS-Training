package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.entity.OrderEntity;
import com.jspexample.JspExample.model.BookModel;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.model.OrderModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class CustomBeanUtils {

    public static BookEntity convertBookModelToEntity(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookModel, bookEntity);
        return bookEntity;
    }

    public static BookModel convertBookEntityToModel(BookEntity bookEntity) {
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(bookEntity, bookModel);
        return bookModel;
    }

    public static List<BookModel> convertListOfBooksToModels(List<BookEntity> bookEntities) {
        List<BookModel> bookModels = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            BookModel bookModel = new BookModel();
            BeanUtils.copyProperties(bookEntity, bookModel);
            bookModels.add(bookModel);
        }
        return bookModels;
    }

    public static List<CustomerModel> convertListOfCustomersToModels(List<CustomerEntity> customerEntities) {
        List<CustomerModel> customerModels = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            CustomerModel customerModel = new CustomerModel();
            BeanUtils.copyProperties(customerEntity, customerModel);
            customerModels.add(customerModel);
        }
        return customerModels;
    }

    public static CustomerModel convertCustomerEntityToModel(CustomerEntity customerEntity) {
        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customerEntity, customerModel);
        return customerModel;
    }

    public static CustomerEntity convertCustomerModelToEntity(CustomerModel customerModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        if (customerModel != null) BeanUtils.copyProperties(customerModel, customerEntity);

        return customerEntity;
    }

    public static List<OrderModel> convertListOfOrderToModels(List<OrderEntity> orderEntities) {

//
        List<OrderModel> orderModels = new ArrayList<>();

        for (OrderEntity orderEntity1 : orderEntities) {
            OrderModel orderModel = new OrderModel();

            BeanUtils.copyProperties(orderEntity1, orderModel);

            //// Copy the customer
            CustomerEntity customerEntity = orderEntity1.getCustomer();
            if (customerEntity != null) {
                CustomerModel customerModel = CustomBeanUtils.convertCustomerEntityToModel(customerEntity);
                orderModel.setCustomer(customerModel);
            }

            //// Copy books
            List<BookEntity> bookEntities = orderEntity1.getBooks();
            if (bookEntities != null && !bookEntities.isEmpty()) {

                List<BookModel> bookModels = CustomBeanUtils.convertListOfBooksToModels(bookEntities);
                orderModel.setBooks(bookModels);
            }

            orderModels.add(orderModel);
        }

        return orderModels;
    }

}
