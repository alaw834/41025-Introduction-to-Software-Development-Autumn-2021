<%-- 
    Document   : deleteCreditCard
    Created on : 14/05/2021, 8:35:20 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Remove Credit Card</title>
    </head>
    <body>
        
        <% 
            String deletedCreditCard = (String) session.getAttribute("deleted");
        %>
        
        <ul>
            <li><a href="main.jsp">Payment Options</a></li>
        </ul>
        
        <h1>Remove Credit Card</h1><span><%=(deletedCreditCard != null ? deletedCreditCard : "")%></span>
        <form method="post" action="DeleteCreditCardServlet">
            <table>
                <tr><td>Card ID: </td><td><input type="text" placeholder="Enter existing Card ID" name="cardID"></td></tr>
                <tr><td></td><td><input type="submit" value="Remove Credit Card"></td></tr>
            </table>
        </form>
          
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
