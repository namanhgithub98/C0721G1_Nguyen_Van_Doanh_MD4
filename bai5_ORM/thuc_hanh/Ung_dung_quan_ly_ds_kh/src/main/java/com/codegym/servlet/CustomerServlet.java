package com.codegym.servlet;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceFactory;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "CustomerServlet")
public class CustomerServlet extends javax.servlet.http.HttpServlet {
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));

        Long id = Long.valueOf(request.getParameter("id"));
        customer.setId(id);
        customerService.save(customer);

        response.sendRedirect("/customers/list.jsp");
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
