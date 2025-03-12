package com.jspexample.JspExample.validator;


import com.jspexample.JspExample.model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerModel customerModel= (CustomerModel) target;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "name.empty");
        String pwd=customerModel.getPassword();
        if (!pwd.isEmpty()) {
            if (pwd.charAt(0) >= 'A' && pwd.charAt(0) <= 'Z') {
            } else errors.rejectValue("password", "password");
        }
    }
}
