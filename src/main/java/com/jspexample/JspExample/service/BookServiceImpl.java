package com.jspexample.JspExample.service;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.exception.BookNotFoundException;
import com.jspexample.JspExample.model.BookModel;
import com.jspexample.JspExample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public void saveBook(BookModel bookModel) {

        BookEntity bookEntity = CustomBeanUtils.convertBookModelToEntity(bookModel);
        bookRepository.save(bookEntity);
    }

    public List<BookModel> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();

        return CustomBeanUtils.convertListOfBooksToModels(bookEntities);
    }

    public BookModel getBookById(Integer id) throws BookNotFoundException {
        Optional<BookEntity> opBook = bookRepository.findById(id);
        BookEntity bookEntity = opBook.orElseThrow(() -> new BookNotFoundException("Book not found with given ID"));
        if (bookEntity != null) {
            return CustomBeanUtils.convertBookEntityToModel(bookEntity);
        }
        return null;

    }

    public BookEntity getBookEntityById(Integer id) {
        Optional<BookEntity> opBook = bookRepository.findById(id);
        return opBook.orElse(null);

    }

    public void updateBookQty(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<BookEntity> advancedSearch(String title, String author, Double priceMin, Double priceMax, Integer stock) {
        return bookRepository.findBooksByAdvancedSearch(title, author, priceMin, priceMax, stock);
    }
}
