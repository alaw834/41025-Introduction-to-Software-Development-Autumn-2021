/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.dao.PaymentManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1234
 */
public class DisplayPaymentServlet extends HttpServlet {

    Customer customer;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        customer = (Customer) session.getAttribute("customer");

        try {
            out.println("<table class=\"records\">");
            out.println("<tr><th>Payment ID</th><th>Order ID</th><th>Payment Type</th><th>Payment Date</th></tr>");
            String allRecords = manager.fetchPayment(customer.getCustomerID());
            out.println(allRecords);
            out.println("</table>");

        } catch (Exception e) {
            out.println("Error");
        }

    }

}
