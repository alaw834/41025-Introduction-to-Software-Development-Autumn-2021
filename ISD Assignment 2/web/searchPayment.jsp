<%-- 
    Document   : searchPayment
    Created on : 15/05/2021, 1:07:07 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Search Payment Record</title>
    </head>
    <body>
        
        <%
            String existErr = (String) session.getAttribute("existErr");
            String paymentDateErr = (String) session.getAttribute("paymentDateErr");
            String searchedpaymentID = (String) session.getAttribute("searchedpaymentID");
            String orderID = (String) session.getAttribute("orderID");
            String paymentType = (String) session.getAttribute("paymentType");
            String searchedpaymentDate = (String) session.getAttribute("searchedpaymentDate");
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
        
        <h1>Search Payment Record</h1>
        <span><%=(paymentDateErr != null ? paymentDateErr : "")%></span>
        <span><%=(existErr != null ? existErr : "")%></span>
        <form method="post" action="SearchPaymentServlet">
            <table>
                <td>Search Payment History: </td>
                <td><input type="text" placeholder="" name="paymentID"></td>
                <td><input type="date" name="paymentDate"></td>
                <td><input type="submit" value="Search"> </td>
            </table>
        </form>
        
        <table class="records">
            <tr><th>Payment ID</th><th>Order ID</th><th>Payment Type</th><th>Payment Date</th></tr>
            <tr>
                <td><%=(searchedpaymentID != null ? searchedpaymentID : "")%></td>
                <td><%=(orderID != null ? orderID : "")%></td>
                <td><%=(paymentType != null ? paymentType : "")%></td>
                <td><%=(searchedpaymentDate != null ? searchedpaymentDate : "")%></td>
            </tr>
        </table>
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
