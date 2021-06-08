<%-- 
    Document   : submitPayment
    Created on : 16/05/2021, 1:46:22 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Submit Payment</title>
    </head>
    <body>
        
        <%
            String paymentMade = (String) session.getAttribute("paymentMade");
            String dateErr = (String) session.getAttribute("dateErr");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Submit Payment</h1>
        <span><%=(paymentMade != null ? paymentMade : "")%></span>
        <span><%=(dateErr != null ? dateErr : "")%></span>
        <form method="post" action="SubmitPaymentServlet">
            <table>
                <tr><td>Payment ID: </td><td><input type="text" name="paymentID"></td></tr>
                <tr><td>Payment Date: </td><td><input type="date" name="paymentDate"></td></tr>
                <tr><td></td><td><input type="submit" value="Submit Payment"></td></tr>
            </table>
        </form>
        
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
