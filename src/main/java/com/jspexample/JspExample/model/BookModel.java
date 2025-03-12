package com.jspexample.JspExample.model;

import jakarta.validation.constraints.*;

//@Component
public class BookModel {

    private int bookId;

    @NotNull(message = "Title cannot be null")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 50 characters")
    private String title;

    @NotNull(message = "Author cannot be null")
    @Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
    private String author;

    @Positive(message = "Price must be greater than zero")
    private double price;

    @Min(value = 1, message = "Stock must be greater than zero")
    private int stock;

    public BookModel() {
    }

    public BookModel(int bookId, String title, String author, double price, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
