package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.User;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.LogManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
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
 * @author alaw8
 */
public class DeleteCustomerServlet extends HttpServlet {

    private UserManager usermanager;
    private CustomerManager customermanager;
    private LogManager logmanager; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get all necessary parameters from the session
        HttpSession session = request.getSession();
        logmanager = (LogManager) session.getAttribute("logManager");
        usermanager = (UserManager) session.getAttribute("userManager");
        customermanager = (CustomerManager) session.getAttribute("customerManager");
        
        User user = (User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customer");

        try { //Delete all record in the database related to customer and invalidate session
            logmanager.deleteLog(user.getUserID());
            customermanager.deleteCustomer(customer.getUserID());
            usermanager.deleteUser(user.getUserID());
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Failed to delete account" : "Error");
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("customerprofile.jsp").include(request, response);
        }
    }
}
