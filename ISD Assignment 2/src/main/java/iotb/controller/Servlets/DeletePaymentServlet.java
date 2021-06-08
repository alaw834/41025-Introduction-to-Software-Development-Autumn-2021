/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.Payment;
import iotb.model.dao.CreditCardManager;
import iotb.model.dao.PaymentManager;
import iotb.model.dao.PaypalManager;
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
public class DeletePaymentServlet extends HttpServlet {
    PaypalManager ppmanager;
    CreditCardManager ccmanager;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        
        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        try {
            Payment payment = manager.readPayment(Integer.parseInt(paymentID));
            
            if(payment != null) {
                if(payment.getPaymentType().equals("1")){
                    ccmanager.deleteCreditCard(Integer.parseInt(paymentID));
                    manager.deletePayment(Integer.parseInt(paymentID));
                    session.setAttribute("deletedPayment", "Payment successfully removed");
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
                else{
                    ppmanager.deletePaypal(Integer.parseInt(paymentID));
                    manager.deletePayment(Integer.parseInt(paymentID));
                    session.setAttribute("deletedPayment", "Payment successfully removed");
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }

            } else {
                session.setAttribute("deletedPayment", "Payment does not exist");
                request.getRequestDispatcher("deletePayment.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DeletePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
