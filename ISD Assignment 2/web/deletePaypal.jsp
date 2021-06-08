<%-- 
    Document   : deletePaypal
    Created on : 14/05/2021, 8:59:22 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Remove PayPal Account</title>
    </head>
    <body>
        <% 
            String deletedPaypal = (String) session.getAttribute("deletedPaypal");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Remove PayPal Account</h1><span><%=(deletedPaypal != null ? deletedPaypal : "")%></span>
        <form method="post" action="DeletePaypalServlet">
            <table>
                <tr><td>PayPal ID: </td><td><input type="text" placeholder="Enter existing PayPal ID" name="paypalID"></td></tr>
                <tr><td></td><td><input type="submit" value="Remove PayPal Account"></td></tr>
            </table>
        </form> 
        
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
