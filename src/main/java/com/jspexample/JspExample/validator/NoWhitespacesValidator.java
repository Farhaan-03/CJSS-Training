package com.jspexample.JspExample.validator;

import com.jspexample.JspExample.annotations.NoWhitespaces;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoWhitespacesValidator implements ConstraintValidator<NoWhitespaces,Object> {
    @Override
    public void initialize(NoWhitespaces constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof String) {
            String value = (String) o;

            if (value.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
