package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.Staff;
import iotb.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotb.model.dao.LogManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogoutServlet extends HttpServlet {

    private LogManager logmanager;

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //Get all necessary parameters from the session
        User user = (User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customer");
        Staff staff = (Staff) session.getAttribute("staff");
        
        //Get the managers to be used from session
        logmanager = (LogManager) session.getAttribute("logManager");
        
        //Get current date and time to add to accesslog
        Date date = new Date();

        //If the person logging out is a customer
        if (user != null && customer != null) {
            try {
                logmanager.addCustomerLog(user.getUserID(), date, "Logout"); //Add a accesslog for that customer
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (user != null && staff != null) {
            try {
                logmanager.addStaffLog(staff.getStaffID(), date, "Logout");  //Add a accesslog for that staff member
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        session.invalidate(); //Invalidate session
        request.getRequestDispatcher("index.jsp").include(request, response); //Redirect to index
    }
}
