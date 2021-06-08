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
public class SearchPaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String paymentID = request.getParameter("paymentID");
        String paymentDate = request.getParameter("paymentDate");
        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        Payment payment = null;
        validator.clear(session);
        
        if (!validator.validatePaymentDate(paymentDate)){
            session.setAttribute("paymentDateErr", "Error: Payment date missing");
            request.getRequestDispatcher("searchPayment.jsp").include(request, response);
        } else {
            try {
                payment = manager.readPayment(Integer.parseInt(paymentID));
                if (payment != null) {
                    String searchedpaymentID = payment.getPaymentID();
                    String orderID = payment.getOrderID();
                    String paymentType = payment.getPaymentType();
                    String searchedpaymentDate = payment.getPaymentDate();
                    session.setAttribute("searchedpaymentID", searchedpaymentID);
                    session.setAttribute("orderID", orderID);
                    session.setAttribute("paymentType", paymentType);
                    session.setAttribute("searchedpaymentDate", searchedpaymentDate);
                    request.getRequestDispatcher("searchPayment.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "Error: Payment does not exist");
                    request.getRequestDispatcher("searchPayment.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
