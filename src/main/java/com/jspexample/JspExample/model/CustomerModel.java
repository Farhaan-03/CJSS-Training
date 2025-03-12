package com.jspexample.JspExample.model;


import com.jspexample.JspExample.annotations.NoWhitespaces;
import com.jspexample.JspExample.annotations.PhoneNo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {


    private int customerId;

    @NoWhitespaces(message = "Customer Name cannot be empty or contains Whitespaces.")
    @Size(min = 3, max = 50, message = "Customer Name must be between 3 and 50 characters.")
    private String customerName;


    @Email(message = "Please provide a valid email address.")
    @NoWhitespaces(message = "Email must not be empty or contain whitespaces")
    private String email;

    @NotNull(message = "Phone Number cannot be null.")
    /// constraint validations
    @PhoneNo(message = "Please provide a valid  10 digit phone number.")
    private long phoneNo;

    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @NoWhitespaces(message = "Password can't be empty or contain whitespaces")
    private String password;




}
