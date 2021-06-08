/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.Validator;
import iotb.model.CreditCard;
import iotb.model.dao.CreditCardManager;
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
public class DeleteCreditCardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String cardID = request.getParameter("cardID");
        
        CreditCardManager manager = (CreditCardManager) session.getAttribute("creditcardManager");
        validator.clear(session);
        
        try {
            CreditCard creditcard = manager.readCreditCard(Integer.parseInt(cardID));
            
            if(creditcard != null) {
                manager.deleteCreditCard(Integer.parseInt(cardID));
                session.setAttribute("deletedCreditCard", "Credit Card successfully removed");
                request.getRequestDispatcher("main.jsp").include(request, response);
            } else {
                session.setAttribute("deletedCreditCard", "Credit Card does not exist");
                request.getRequestDispatcher("deleteCreditCard.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DeletePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
