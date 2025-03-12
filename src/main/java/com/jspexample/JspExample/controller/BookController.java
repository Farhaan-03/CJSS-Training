package com.jspexample.JspExample.controller;

import com.jspexample.JspExample.entity.BookEntity;
import com.jspexample.JspExample.model.BookModel;
import com.jspexample.JspExample.service.BookService;
import com.jspexample.JspExample.validator.BookValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    BookValidator bookValidator;

    @GetMapping("/book-form")
    public String bookForm(Model model, BookModel bookModel) {

        model.addAttribute("book", bookModel);
        return "book-form";

    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("book") BookModel bookModel, BindingResult bindingResult) {

        bookValidator.validate(bookModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "book-form";
        }
        bookService.saveBook(bookModel);

        return "redirect:/books";
    }


    @GetMapping("/books")
    public String getAllBooks(Model model) {

        List<BookModel> bookModels = bookService.getAllBooks();
        model.addAttribute("books", bookModels);

        return "books";
    }

    @GetMapping("/delete-book/{bookId}")
    public String deleteBookById(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }

    @GetMapping("/update-book/{bookId}")
    public String showUpdateBookForm(@PathVariable int bookId, Model model) {

        BookEntity bookEntity = bookService.getBookEntityById(bookId);

        model.addAttribute("book", bookEntity);
        return "updateBookForm";
    }


    @PostMapping("/update-book/{bookId}")
    public String updateBook(@PathVariable("bookId") int bookId,
                             @Valid @ModelAttribute("book") BookModel bookModel, BindingResult bindingResult) {

        bookValidator.validate(bookModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "updateBookForm";
        }

        BookEntity bookEntity = bookService.getBookEntityById(bookId);

        bookEntity.setTitle(bookModel.getTitle());
        bookEntity.setAuthor(bookModel.getAuthor());
        bookEntity.setPrice(bookModel.getPrice());
        bookEntity.setStock(bookModel.getStock());

        bookService.updateBookQty(bookEntity);

        return "redirect:/books";
    }


    @GetMapping("/searchbook")
    public String getSearchForm() {
        return "searchbook";
    }

    @GetMapping("/search")
    public String getBookById( @RequestParam int bookId, Model model, BookModel bookModel) {

        bookModel = bookService.getBookById(bookId);

        model.addAttribute("book", bookModel);

        return "searchbook";
    }

    @GetMapping("/advanced-search")
    public String getAdvSearchForm() {
        return "advanced-search";

    }

    @GetMapping("/advanced")
    public String advancedSearch(@RequestParam(value = "title", required = false) String title,
                                 @RequestParam(value = "author", required = false) String author,
                                 @RequestParam(value = "priceMin", required = false) Double priceMin,
                                 @RequestParam(value = "priceMax", required = false) Double priceMax,
                                 @RequestParam(value = "stock", required = false) Integer stock,
                                 Model model) {

        List<BookEntity> books = bookService.advancedSearch(title, author, priceMin, priceMax, stock);

        model.addAttribute("books", books);

        return "searchResults";
    }

}
