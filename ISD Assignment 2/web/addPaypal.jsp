<%-- 
    Document   : addPaypal
    Created on : 13/05/2021, 6:00:10 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Add PayPal Account</title>
    </head>
    <body>
        
        <%
            String paypalUsernameErr = (String) session.getAttribute("paypalUsernameErr");
            String paypalPasswordErr = (String) session.getAttribute("paypalPasswordErr");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Add PayPal Account</h1>
        <form method="post" action="CreatePaypalServlet">
            <table>
                <tr><td>Existing Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td>PayPal Username: </td><td><input type="text" placeholder="<%=(paypalUsernameErr != null ? paypalUsernameErr : "Enter PayPal Username")%>" name="paypalUsername"></td></tr>
                <tr><td>PayPal Password </td><td><input type="password" placeholder="<%=(paypalPasswordErr != null ? paypalPasswordErr : "Enter PayPal Password")%>" name="paypalPassword"></td></tr>
                <tr><td></td><td><input type="submit" value="Add PayPal account"></td></tr>
            </table>
        </form>

    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
