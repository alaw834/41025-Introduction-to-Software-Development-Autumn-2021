/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.dao.CreditCardManager;
import iotb.model.dao.PaymentManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1234
 */
public class DisplayCreditCardServlet extends HttpServlet {
    Customer customer;
    PaymentManager pmanager;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        
        CreditCardManager manager = (CreditCardManager) session.getAttribute("creditcardManager");
        customer = (Customer) session.getAttribute("customer");
        pmanager = (PaymentManager) session.getAttribute("paymentManager");
        try {
            out.println("<table class=\"records\">");
            out.println("<tr><th>Payment ID</th><th>Card ID</th><th>Card Number</th><th>Expiry Date</th><th>Holder Name</th><th>CVV</th></tr>");
            String allRecords = manager.fetchCreditCard(Integer.parseInt(pmanager.fetchCardPayment(customer.getCustomerID())));
            out.println(allRecords);
            out.println("</table>");
            
        } catch (Exception e){
            out.println("Error");
        }
        
    }

}
