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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;

/**
 *
 * @author 1234
 */
public class CreatePaymentServlet extends HttpServlet {

        private PaymentManager manager;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String orderID = request.getParameter("orderID");
        String paymentType = request.getParameter("paymentType");
        
        manager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        if(!validator.validatePaymentType(paymentType)) {
            session.setAttribute("paymentTypeErr", "Error: Payment type does not exist"); //Kind of redundant since HTML form only takes 1 or 2
        } else {
            try {
                manager.addPayment(Integer.parseInt(orderID), Integer.parseInt(paymentType));
                // Payment payment = new Payment(paymentID, orderID, paymentType);
                // session.setAttribute("payment", payment);
                if (paymentType.equals("1")) { // if payment type is 1 then go to add credit card page else go to paypal page
                    request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
                } else {
                    request.getRequestDispatcher("addPaypal.jsp").include(request, response);
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CreatePaymentServlet.class.getName()).log(Logger.Level.FATAL, manager, ex);
            }
        }
    }

    

}
