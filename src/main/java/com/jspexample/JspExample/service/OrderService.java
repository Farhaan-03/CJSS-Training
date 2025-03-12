package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    void saveOrder(OrderModel orderModel, List<BookEntity> bookEntities, CustomerEntity customerEntity);


    void deleteOrderById(int orderId);

    OrderModel getOrderById(int orderId);

    void updateOrder(OrderModel orderModel, List<BookEntity> bookEntities, CustomerEntity customerEntity, int quantity);

    List<OrderModel> getAllOrders();

    List<OrderModel> findByCustomer(CustomerModel customerModel);
}
