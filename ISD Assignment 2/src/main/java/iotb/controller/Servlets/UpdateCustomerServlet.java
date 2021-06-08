package iotb.controller.Servlets;

import iotb.controller.UpdateValidator;
import iotb.model.Customer;
import iotb.model.User;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
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
 * @author alaw8
 */
public class UpdateCustomerServlet extends HttpServlet {

    private UserManager usermanager;
    private CustomerManager customermanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get all necessary parameters from the session
        HttpSession session = request.getSession();
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phonenum = request.getParameter("phonenumber");
        String streetnum = request.getParameter("streetnumber");
        String streetname = request.getParameter("streetname");
        String postcode = request.getParameter("postcode");

        //Get the managers to be used from session
        usermanager = (UserManager) session.getAttribute("userManager");
        customermanager = (CustomerManager) session.getAttribute("customerManager");

        //Get necessary validator for servlet
        UpdateValidator validator = new UpdateValidator();
        validator.clear(session);

        //Validate all incoming variables to be used for feature
        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Email Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validateName(fName)) {
            session.setAttribute("fnameErr", "First Name Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validateName(lName)) {
            session.setAttribute("lnameErr", "Last Name Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Password Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validateDob(dob)) {
            session.setAttribute("dobErr", "DOB Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validatePhoneNum(phonenum)) {
            session.setAttribute("phoneErr", "Phone Number Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validateNum(streetnum)) {
            session.setAttribute("streetNumErr", "Street Number Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validatestreetName(streetname)) {
            session.setAttribute("streetNameErr", "Street Name Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else if (!validator.validatePostCode(postcode)) {
            session.setAttribute("postcodeErr", "Post Code Format Incorrect");
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
        } else {
            try {
                User user = (User) session.getAttribute("user"); //Get the current user from session
                int userID = user.getUserID();
                usermanager.updateUser(userID, fName, lName, email, password, phonenum); //Update the user to the parameters that were passed
                customermanager.updateCustomer(userID, customermanager.getID(userID), dob, Integer.parseInt(streetnum), streetname, Integer.parseInt(postcode), true);
                User updateduser = new User(userID, fName, lName, email, password, phonenum);
                Customer customer = customermanager.readCustomer(user.getUserID());
                session.setAttribute("user", updateduser); //Set the updated user to the session
                session.setAttribute("customer", customer); //Set the updated customer to the session
                request.getRequestDispatcher("customerprofile.jsp").include(request, response); //Redirect to customer profule
            } catch (SQLException | NullPointerException ex) { //Redirect to same page if there is an exception
                System.out.println(ex.getMessage() == null ? "Failed to update customer" : "Error");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
