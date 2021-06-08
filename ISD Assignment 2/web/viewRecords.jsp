<%-- 
    Document   : viewRecords
    Created on : 14/05/2021, 12:20:20 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Payment Records</title>
    </head>
    <body>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Payment Records</h1>
        <h2>Payment Details</h2>
        <jsp:include page="/DisplayPaymentServlet" flush="true"/>
        <h2>Credit Card Details</h2>
        <jsp:include page="/DisplayCreditCardServlet" flush="true"/>
        <h2>PayPal Details</h2>
        <jsp:include page="/DisplayPaypalServlet" flush="true"/>
        
        
        <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
