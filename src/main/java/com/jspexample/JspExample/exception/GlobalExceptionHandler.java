package com.jspexample.JspExample.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public String handleProductNotFound(BookNotFoundException exception, Model model, HttpServletRequest request) {
        System.out.println("request uri " + request.getRequestURI());

        model.addAttribute("exception", "Custom Exception : " + exception.getMessage());
        return "searchbook";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllExceptions(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "errorPage";
    }

}
