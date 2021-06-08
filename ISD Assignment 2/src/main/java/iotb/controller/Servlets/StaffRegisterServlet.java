package iotb.controller.Servlets;

import iotb.controller.RegisterValidator;
import iotb.model.Staff;
import iotb.model.User;
import iotb.model.dao.StaffManager;
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
public class StaffRegisterServlet extends HttpServlet {

    private UserManager usermanager;
    private StaffManager staffmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get all necessary parameters from the session
        HttpSession session = request.getSession();
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phonenum = request.getParameter("phonenumber");

        //Get the managers to be used from session
        usermanager = (UserManager) session.getAttribute("userManager");
        staffmanager = (StaffManager) session.getAttribute("staffManager");

        //Get necessary validator for servlet
        RegisterValidator validator = new RegisterValidator();
        validator.clear(session);

        //Validate all incoming variables to be used for feature
        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Email Format Incorrect");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        } else if (!validator.validateName(fName)) {
            session.setAttribute("fnameErr", "First Name Format Incorrect");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        } else if (!validator.validateName(lName)) {
            session.setAttribute("lnameErr", "Last Name Format Incorrect");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Password Format Incorrect");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        } else if (!validator.validatePhoneNum(phonenum)) {
            session.setAttribute("phoneErr", "Phone Number Format Incorrect");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        } else {
            try {
                User exist = usermanager.readUser(email, password);
                if (exist != null) { //If a user exists, set error message and redirect to same page
                    session.setAttribute("existErr", "Staff Already Exists!");
                    request.getRequestDispatcher("staffregister.jsp").include(request, response);
                } else {
                    usermanager.addUser(fName, lName, email, password, phonenum); //Add new user
                    staffmanager.addStaff(usermanager.getID(email, password)); //Add new staff
                    User user = new User(usermanager.getID(email, password), fName, lName, email, password, phonenum);
                    Staff staff = staffmanager.readStaff(user.getUserID());
                    session.setAttribute("user", user); //Set new user to session
                    session.setAttribute("staff", staff); //Set new staff to session
                    request.getRequestDispatcher("staffhome.jsp").include(request, response); //Redirect to staff home
                }
            } catch (SQLException | NullPointerException ex) { //Redirect to same page if there is an exception
                System.out.println(ex.getMessage() == null ? "Failed to sign up staff" : "Error");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("staffregister.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
