package com.jspexample.JspExample.validator;


import com.jspexample.JspExample.annotations.PhoneNo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNoValidator implements ConstraintValidator<PhoneNo, Long> {

    @Override
    public void initialize(PhoneNo phoneNo) {

    }

    @Override
    public boolean isValid(Long phoneNo, ConstraintValidatorContext context) {
        if (phoneNo == null) {
            return false;
        }

        String phoneStr = String.valueOf(phoneNo);
        return phoneStr.matches("\\d{10}");
    }
}
