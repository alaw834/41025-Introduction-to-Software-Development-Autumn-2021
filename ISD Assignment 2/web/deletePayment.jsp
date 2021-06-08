<%-- 
    Document   : deletePayment
    Created on : 14/05/2021, 7:33:11 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Remove Payment Details</title>
    </head>
    <body>
        
        <% 
            String deletedPayment = (String) session.getAttribute("deletedPayment");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Remove Payment Details</h1><span><%=(deletedPayment != null ? deletedPayment : "")%></span>
        <form method="post" action="DeletePaymentServlet">
            <table>
                <tr><td>Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td></td><td><input type="submit" value="Remove Payment"></td></tr>
            </table>
        </form>

    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
