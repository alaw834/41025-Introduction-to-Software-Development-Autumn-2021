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
import java.text.ParseException;
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
public class UpdatePaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        String orderID = request.getParameter("orderID");
        String paymentType = request.getParameter("paymentType");
        
        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        if(!validator.validatePaymentType(paymentType)) {
            session.setAttribute("paymentTypeErr", "Error: Payment type does not exist"); //Kind of redundant since HTML form only takes 1 or 2
        } else {
            try {
                
                Payment payment = manager.readPayment(Integer.parseInt(paymentID));
                
                if(payment != null) {
                    manager.updatePayment(Integer.parseInt(paymentID), Integer.parseInt(orderID), Integer.parseInt(paymentType));
                    session.setAttribute("updatedPayment", "Payment successfully updated");
                    request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                } else {
                    session.setAttribute("updatedPayment", "Payment does not exist");
                    request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                }
    
            } catch (SQLException ex) {
                Logger.getLogger(CreatePaymentServlet.class.getName()).log(Logger.Level.FATAL, manager, ex);
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(UpdatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
