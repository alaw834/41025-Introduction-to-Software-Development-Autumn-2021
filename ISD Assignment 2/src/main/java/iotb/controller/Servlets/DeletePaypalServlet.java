/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.Paypal;
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
public class DeletePaypalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paypalID = request.getParameter("paypalID");
        
        PaypalManager manager = (PaypalManager) session.getAttribute("paypalManager");
        validator.clear(session);
        
        try {
            Paypal paypal = manager.readPaypal(Integer.parseInt(paypalID));
            
            if(paypal != null) {
                manager.deletePaypal(Integer.parseInt(paypalID));
                session.setAttribute("deletedPaypal", "PayPal Account successfully removed");
                request.getRequestDispatcher("main.jsp").include(request, response);
            } else {
                session.setAttribute("deletedPaypal", "PayPal Account does not exist");
                request.getRequestDispatcher("deletePaypal.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DeletePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
