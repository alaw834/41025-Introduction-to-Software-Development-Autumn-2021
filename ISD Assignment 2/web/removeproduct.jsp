<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Remove Product</title>
    </head>
    <%
        String productIDErr = (String) session.getAttribute("productIDErr");
    %>
    <body>
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

        <div id="title"> 
            <h1>Remove a product</h1>
        </div>

        <div id="registerform">
         <form action="DeleteProductServlet" method="Post">
             
                <table id="addProductTable">
                    <tr>    
                        <td  align="right">Product ID:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productIDErr != null ? productIDErr : "Enter Product ID")%>" name="productID" required/></td>    
                    </tr>
                    <tr>                       
                        <td colspan="2" id="submitButton"><input class="button" type="submit" value="Delete Product"></td>
                    </tr>
                </table>
            <input type="hidden" value="removeproduct">
        </form>

    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</body>
<jsp:include page="/ConnectionServlet" flush="true" />
</html>
