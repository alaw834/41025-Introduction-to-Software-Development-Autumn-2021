<%-- 
    Document   : updateCreditCard
    Created on : 14/05/2021, 10:54:10 AM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Update Credit Card Details</title>
    </head>
    <body>
        
        <%
            String expiryDateErr = (String) session.getAttribute("expiryDateErr");
            String cardNumberErr = (String) session.getAttribute("cardNumberErr");
            String holderNameErr = (String) session.getAttribute("holderNameErr");
            String cvvErr = (String) session.getAttribute("cvvErr");
            String updatedCreditCard = (String)session.getAttribute("updatedCreditCard");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Edit Credit Card Details</h1>
        <span><%=(updatedCreditCard != null ? updatedCreditCard : "")%></span>
        <span><%=(expiryDateErr != null ? expiryDateErr : "")%></span>
        <form method="post" action="UpdateCreditCardServlet">
            <table>
                <tr><td>Card ID: </td><td><input type="text" placeholder="Enter existing Card ID" name="cardID"></td></tr>
                <tr><td>Card Number: </td><td><input type="text" placeholder="<%=(cardNumberErr != null ? cardNumberErr : "Enter 16-digit card number")%>" name="cardNumber"></td></tr>
                <tr><td>Expiry date: </td><td><input type="date" name="expiryDate"></td></tr>
                <tr><td>Card Holder Name: </td><td><input type="text" placeholder="<%=(holderNameErr != null ? holderNameErr : "Enter holder name")%>" name="holderName"></td></tr>
                <tr><td>CVV: </td><td><input type="text" placeholder="<%=(cvvErr != null ? cvvErr : "Enter 3-digit CVV number")%>" name="cvv"></td></tr>
                <tr><td></td><td><input type="submit" value="Update credit card"></td></tr>
            </table>
        </form>
        
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
