/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.dao.PaypalManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
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
public class CreatePaypalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        String paypalUsername = request.getParameter("paypalUsername");
        String paypalPassword = request.getParameter("paypalPassword");
        
        PaypalManager manager = (PaypalManager) session.getAttribute("paypalManager");
        validator.clear(session);
        
        if(!validator.validatePaypalUsername(paypalUsername)){
            session.setAttribute("paypalUsernameErr", "Error: PayPal username format incorrect");
            request.getRequestDispatcher("addPaypal.jsp").include(request, response);
        } else if(!validator.validatePaypalPassword(paypalPassword)) {
            session.setAttribute("paypalPassword", "Error: PayPal password format incorrect");
            request.getRequestDispatcher("addPaypal.jsp").include(request, response);
        } else {
            try {
                manager.addPaypal(Integer.parseInt(paymentID), paypalUsername, paypalPassword);
                request.getRequestDispatcher("main.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CreatePaypalServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CreatePaypalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
