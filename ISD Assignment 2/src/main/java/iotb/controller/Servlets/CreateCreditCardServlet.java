/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.dao.CreditCardManager;
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
public class CreateCreditCardServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String holderName = request.getParameter("holderName");
        String cvv = request.getParameter("cvv");
        
        CreditCardManager manager = (CreditCardManager) session.getAttribute("creditcardManager");
        validator.clear(session);
        
        if(!validator.validateCardNumber(cardNumber)){
            session.setAttribute("cardNumberErr", "Error: Card number format is incorrect");
            request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
        } else if(!validator.validateExpiryDate(expiryDate)) {
            session.setAttribute("expiryDateErr", "Error: Expiry date format is incorrect");
            request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
        } else if(!validator.validateHolderName(holderName)) {
            session.setAttribute("holderNameErr", "Error: Holder name format is incorrect");
            request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
        } else if(!validator.validateCVV(cvv)) {
            session.setAttribute("cvvErr", "Error: CVV format is incorrect");
            request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
        } else {
            try {
                manager.addCreditCard(Integer.parseInt(paymentID), cardNumber, expiryDate, holderName, cvv);
                request.getRequestDispatcher("main.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CreatePaymentServlet.class.getName()).log(Logger.Level.FATAL, manager, ex);
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(CreateCreditCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
