<%-- 
    Document   : updatePayment
    Created on : 14/05/2021, 3:52:03 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Update Payment Details</title>
    </head>
    <body>
        
        <%
             String updatedPayment = (String)session.getAttribute("updatedPayment");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Update Payment Details</h1><span><%=(updatedPayment != null ? updatedPayment : "")%></span>
        <form method="post" action="UpdatePaymentServlet">
            <table>
                <tr><td>Existing Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
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
                    <td><input type="submit" value="Update Payment details"></td>
                </tr>
            </table>
        </form>
 
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
