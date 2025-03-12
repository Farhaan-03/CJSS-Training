package com.jspexample.JspExample.controller;

import com.jspexample.JspExample.entity.CustomerEntity;
import com.jspexample.JspExample.model.CustomerModel;
import com.jspexample.JspExample.service.CustomerService;
import com.jspexample.JspExample.validator.CustomerValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class LoginController {


    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerValidator customerValidator;

    @Autowired
    MessageSource messageSource;


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession httpSession) {

        if (username.equals("Admin") && password.equals("Admin")) {

            httpSession.setAttribute("user", username);
            System.out.println(httpSession.getAttribute("user") + " logged-in");
            return "redirect:/admin";
        }

        CustomerEntity customerEntity = customerService.getCustomerByName(username);
        if (customerEntity != null && customerEntity.getPassword().equals(password)) {

            httpSession.setAttribute("user", username);
            System.out.println(httpSession.getAttribute("user") + " logged-in");

            return "redirect:/homepage";
        } else {
            model.addAttribute("errorMessage", "Invalid Credential");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {

        System.out.println(httpSession.getAttribute("user") + " logged-out");
        httpSession.removeAttribute("user");
        return "login";
    }


    /// Internationalization
    @GetMapping("/admin")
    public String getAdminPage(Model model, Locale locale) {
        String title = messageSource.getMessage("title", null, locale);
        model.addAttribute("title", title);
        return "Admin-panel";
    }

    @GetMapping("/change-locale")
    public String changeLocale(@RequestParam String lang, Locale locale) {
        locale = new Locale(lang); // Change locale based on the 'lang' parameter
        return "redirect:/admin"; // Redirect to the /admin page to see the language change
    }

    @GetMapping("/homepage")
    public String getHomepage() {
        return "home";
    }

    @GetMapping("/signup")
    public String showSignupForm(CustomerModel customerModel, Model model) {
        model.addAttribute("customer", customerModel);
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute("customer") @Valid CustomerModel customerModel, BindingResult bindingResult, Model model) {

        customerValidator.validate(customerModel, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (customerService.getCustomerByName(customerModel.getCustomerName()) != null) {
            model.addAttribute("NameError", "Username already exists");
            return "signup";
        }
        customerService.saveCustomer(customerModel);
        return "redirect:/login";
    }

}
