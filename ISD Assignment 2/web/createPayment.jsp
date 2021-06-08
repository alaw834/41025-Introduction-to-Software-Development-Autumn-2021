<%-- 
    Document   : createPayment
    Created on : 13/05/2021, 2:58:39 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Add payment</title>
    </head>
    <body>
        
        
        <%
            String paymentTypeErr = (String) session.getAttribute("paymentTypeErr");
        %>
        
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="catalogue.jsp">Catalogue</a></li>
                    <%
                        if (session.getAttribute("user") == null) {
                    %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="staffportal.jsp">Staff Portal</a></li>
                    <%
                    } else if (session.getAttribute("customer") != null) {
                    %>
                <li><a href="customerprofile.jsp">Your Profile</a></li>
                <li><a href="logoutcustomer.jsp">Logout</a></li>
                    <%
                    } else if (session.getAttribute("staff") != null) {
                    %>
                <li><a href="staffhome.jsp">Your Profile</a></li>
                <li><a href="logoutstaff.jsp">Logout</a></li>
                    <%
                        }
                    %>
            </ul>
        </div>
        
        <h1>Add Payment</h1>
        <form method="post" action="CreatePaymentServlet">
            <table>
                <tr><td>Existing Order ID: </td><td><input type="text" placeholder="Enter existing Order ID" name="orderID"></td></tr>
                <tr>
                    <td>Payment Type: </td>
                    <td>
                        <input type="radio" id="creditCard" name="paymentType" value="1">
                        <label for="creditCard">Credit Card</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="radio" id="paypal" name="paymentType" value="2">
                        <label for="paypal">PayPal</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Payment"></td>
                </tr>
            </table>
        </form>

    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
