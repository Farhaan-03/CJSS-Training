package com.jspexample.JspExample.annotations;

import com.jspexample.JspExample.validator.NoWhitespacesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoWhitespacesValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWhitespaces {
    String message() default "Value should not contain  Whitespaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}