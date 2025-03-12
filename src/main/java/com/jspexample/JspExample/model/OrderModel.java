package com.jspexample.JspExample.model;

import jakarta.persistence.OneToOne;

import java.util.List;

public class OrderModel {

    private int orderId;

    private List<BookModel> bookModels;

    private CustomerModel customerModel;
    private int quantity;
    private double totalAmount;

    public OrderModel() {
    }

    public OrderModel(int orderId, List<BookModel> bookModels, CustomerModel customerModel, int quantity, double totalAmount) {
        this.orderId = orderId;
        this.bookModels = bookModels;
        this.customerModel = customerModel;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", books=" + bookModels +
                ", customer=" + customerModel +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<BookModel> getBooks() {
        return bookModels;
    }

    public void setBooks(List<BookModel> bookModels) {
        this.bookModels = bookModels;
    }

    public CustomerModel getCustomer() {
        return customerModel;
    }

    public void setCustomer(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
