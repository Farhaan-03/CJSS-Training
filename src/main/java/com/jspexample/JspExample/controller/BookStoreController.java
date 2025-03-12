package com.jspexample.JspExample.controller;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.model.BookModel;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.model.OrderModel;
import com.jspexample.JspExample.service.BookService;
import com.jspexample.JspExample.service.CustomerService;
import com.jspexample.JspExample.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookStoreController {

    @Autowired
    OrderService orderService;

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;


    @GetMapping("/orders")
    public String getAllOrders(Model model, HttpSession httpSession) {

        String customerName = (String) httpSession.getAttribute("user");
        CustomerModel customerModel = customerService.getCustomerModelByName(customerName);

        boolean isAdmin = customerName.equals("Admin");
        model.addAttribute("isAdmin", isAdmin);


        if (customerName.equals("Admin")) {
            List<OrderModel> orderModels = orderService.getAllOrders();
            model.addAttribute("orders", orderModels);
        } else {
            List<OrderModel> customerOrders = orderService.findByCustomer(customerModel);
            model.addAttribute("orders", customerOrders);
        }
        return "orders";
    }


    @GetMapping("/add-order")
    public String addOrder(Model model, HttpSession httpSession) {

        List<BookModel> bookModels = bookService.getAllBooks();
        model.addAttribute("books", bookModels);

        String customerName = (String) httpSession.getAttribute("user");
        CustomerModel customerModel = customerService.getCustomerModelByName(customerName);
        model.addAttribute("customer", customerModel);

        return "orders-form";
    }


    @PostMapping("/submitOrder")
    public String saveOrder(OrderModel orderModel,
                            @RequestParam("bookId") List<Integer> bookIds,
                            @RequestParam("customerId") int customerId
    ) {

        List<BookEntity> bookEntities = new ArrayList<>();
        for (Integer id : bookIds) {
            bookEntities.add(bookService.getBookEntityById(id));
        }
        CustomerEntity customerEntity = customerService.getCustomerById(customerId);
        orderService.saveOrder(orderModel, bookEntities, customerEntity);

        return "redirect:/orders";

    }


    @GetMapping("/delete/{orderId}")
    public String deleteOrderById(@PathVariable int orderId) {
        orderService.deleteOrderById(orderId);

        return "redirect:/orders";
    }


    @GetMapping("/update/{orderId}")
    public String showUpdateForm(@PathVariable int orderId, Model model, HttpSession httpSession) {

        OrderModel orderModel = orderService.getOrderById(orderId);
        model.addAttribute("order", orderModel);

        String customerName = (String) httpSession.getAttribute("user");
        CustomerModel customerModel = customerService.getCustomerModelByName(customerName);
        model.addAttribute("customer", customerModel);

        return "updateOrderForm";
    }


    @PostMapping("/update/{orderId}")
    public String updateOrder(@PathVariable int orderId,
                              @RequestParam int customerId,
                              @RequestParam int quantity,
                              @RequestParam List<Integer> booksIDs
    ) {

        List<BookEntity> bookEntities = new ArrayList<>();
        for (Integer id : booksIDs) {
            bookEntities.add(bookService.getBookEntityById(id));
        }

        OrderModel orderModel = orderService.getOrderById(orderId);

//   CustomerEntity customerEntity = customerService.getCustomerByName(customerName);
        CustomerEntity customerEntity = customerService.getCustomerById(customerId);

        orderService.updateOrder(orderModel, bookEntities, customerEntity, quantity);

        return "redirect:/orders";

    }


}
