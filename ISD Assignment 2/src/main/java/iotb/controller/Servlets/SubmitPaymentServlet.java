/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.Payment;
import iotb.model.dao.PaymentManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1234
 */
public class SubmitPaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        String paymentDate = request.getParameter("paymentDate");
        
        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        if(!validator.validatePaymentDate(paymentDate)) {
            session.setAttribute("dateErr", "Error: Payment date missing");
            request.getRequestDispatcher("submitPayment.jsp").include(request, response);
        } else {
            try {
                Payment payment = manager.readPayment(Integer.parseInt(paymentID));
                
                if(payment != null && payment.getPaymentDate() == null) {
                    manager.updatePaymentDate(Integer.parseInt(paymentID), paymentDate);
                    session.setAttribute("paymentMade", "Payment successfully submitted");
                    request.getRequestDispatcher("submitPayment.jsp").include(request, response);
                } else {
                    session.setAttribute("paymentMade", "Payment does not exist or payment is already submitted");
                    request.getRequestDispatcher("submitPayment.jsp").include(request, response);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(SubmitPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

}
