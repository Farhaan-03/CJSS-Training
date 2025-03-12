package com.jspexample.JspExample.validator;

import com.jspexample.JspExample.model.BookModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BookModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        BookModel bookModel = (BookModel) target;
///     title
        String title = bookModel.getTitle().trim();

        if (title.isEmpty()) {
            errors.rejectValue("title", "emptyTitle", "Title cannot be empty.");
        } else {
            boolean isAlpha = true;
            boolean hasSpace = false;

            for (int i = 0; i < title.length(); i++) {
                char ch = title.charAt(i);

                if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ')) {
                    isAlpha = false;
                    break;
                }

                if (ch == ' ') {
                    if (hasSpace) {
                        isAlpha = false;
                        break;
                    }
                    hasSpace = true;
                } else {
                    hasSpace = false;
                }
            }
            if (!isAlpha) {
                errors.rejectValue("title", "NonAlphabeticTitle", "Title should be alphabetic and allow only single spaces between words.");
            }
        }
////       author
        if (bookModel.getAuthor().trim().isEmpty()) {
            errors.rejectValue("author", "emptyAuthor");
        } else {
            boolean isAlpha = true;
            for (int i = 0; i < bookModel.getAuthor().length(); i++) {
                char ch = bookModel.getAuthor().charAt(i);
                if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                    isAlpha = false;
                    break;

                }
            }
            if (!isAlpha) errors.rejectValue("author", "NonAlphabetic", "Author should be Alphabetic");

        }

        if (bookModel.getPrice() < 1) {
            errors.rejectValue("price", "lowPrice");
        }


    }
}
