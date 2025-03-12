package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.entity.OrderEntity;
import com.jspexample.JspExample.model.BookModel;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.model.OrderModel;
import com.jspexample.JspExample.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BookService bookService;

    @Autowired
    OrderRepository orderRepository;


    public void saveOrder(OrderModel orderModel, List<BookEntity> bookEntities, CustomerEntity customerEntity) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setBooks(bookEntities);
        orderEntity.setCustomer(customerEntity);

        orderEntity.setQuantity(orderModel.getQuantity());

/// /  update books qty
        orderEntity.getBooks().forEach(bookEntity -> {
            bookEntity.setStock(bookEntity.getStock() - orderEntity.getQuantity());
            bookService.updateBookQty(bookEntity);
        });

        int qty = orderEntity.getQuantity();
        double totalAmt = orderEntity.getTotalAmount();
        for (double price : orderEntity.getBooks().stream().map(BookEntity::getPrice).toList()) {
            totalAmt += (qty * price);
        }
        orderEntity.setTotalAmount(totalAmt);

        orderRepository.save(orderEntity);
    }


    public void deleteOrderById(int orderId) {

        OrderEntity orderEntity = orderRepository.findById(orderId).get();

        orderEntity.getBooks().forEach(bookEntity -> {
            bookEntity.setStock(bookEntity.getStock() + orderEntity.getQuantity());
            bookService.updateBookQty(bookEntity);
        });

        orderRepository.deleteById(orderId);
    }

    public OrderModel getOrderById(int orderId) {

        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(orderEntity, orderModel);

        List<BookEntity> bookEntities = orderEntity.getBooks();
        if (bookEntities != null && !bookEntities.isEmpty()) {
            List<BookModel> bookModels = CustomBeanUtils.convertListOfBooksToModels(bookEntities);
            orderModel.setBooks(bookModels);
        }
        return orderModel;
    }


    public void updateOrder(OrderModel orderModel, List<BookEntity> bookEntities, CustomerEntity customerEntity, int quantity) {

        OrderEntity orderEntity = orderRepository.findById(orderModel.getOrderId()).get();
        orderEntity.setBooks(bookEntities);
        orderEntity.setCustomer(customerEntity);

        for (BookEntity bookEntity : orderEntity.getBooks()) {
            if (orderEntity.getQuantity() > quantity) {
                bookEntity.setStock(bookEntity.getStock() + quantity);
            } else bookEntity.setStock(bookEntity.getStock() - quantity);
        }

        orderEntity.setQuantity(quantity);

        double totalAmount = 0;
        for (BookEntity bookEntity : orderEntity.getBooks()) {
            totalAmount += quantity * bookEntity.getPrice();
        }

        orderEntity.setTotalAmount(totalAmount);

        orderRepository.save(orderEntity);
    }


    public List<OrderModel> getAllOrders() {

        List<OrderEntity> orderEntities = orderRepository.findAll();
        return CustomBeanUtils.convertListOfOrderToModels(orderEntities);
    }

    @Override
    public List<OrderModel> findByCustomer(CustomerModel customerModel) {

        CustomerEntity customerEntity = CustomBeanUtils.convertCustomerModelToEntity(customerModel);

        List<OrderEntity> orderEntities = orderRepository.findAll().stream().filter(order -> order.getCustomer().equals(customerEntity)).toList();
//        System.out.println("imple method");
//       orderEntities.forEach(System.out::println);

        return CustomBeanUtils.convertListOfOrderToModels(orderEntities);

    }
}
