package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.model.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    void saveBook(BookModel bookModel);

    List<BookModel> getAllBooks();

    BookModel getBookById(Integer id);

    BookEntity getBookEntityById(Integer id);

    void updateBookQty(BookEntity bookEntity);

    void deleteBookById(int bookId);

    List<BookEntity> advancedSearch(String title, String author, Double priceMin, Double priceMax, Integer stock);
}
