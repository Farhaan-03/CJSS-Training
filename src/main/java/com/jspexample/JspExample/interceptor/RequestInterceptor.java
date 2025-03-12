package com.jspexample.JspExample.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method - Request URL: " + request.getRequestURL());

//        Object admin = request.getSession().getAttribute("admin");
        Object user = request.getSession().getAttribute("user");
//        request.isUserInRole()


        if (user == null) {

            String errorMessage = "You must log in to access this page.";
            response.sendRedirect("/login?error=" + errorMessage);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        System.out.println("Post Handle method - Response Status: " + response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("After Completion method - Request URL: " + request.getRequestURL());
    }
}
