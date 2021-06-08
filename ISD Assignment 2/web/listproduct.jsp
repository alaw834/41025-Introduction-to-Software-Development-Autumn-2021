<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>List of Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
 
    <%
            ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
    %>
    </head>
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
            <h1>Items for Sale</h1>
        </div>

        <table id="addProductTable">
            <tr>
                <td>Product Name</td>
                <td>Product Description</td>
                <td>Product Category</td>
                <td>Product Price</td>
                <td>Product Stock</td>
            </tr>
            
            <%
                if (productList != null) {
                    for (Product product: productList){
            %>
            <tr>
                <td><%=product.getProductName()%></td>
                <td><%=product.getProductDescription()%></td>
                <td><%=product.getProductCategory()%></td>
                <td><%=product.getProductPrice()%></td>
                <td><%=product.getProductStock()%></td>
            </tr>
            <%}%>
        </table>
        </div>
        <% }%>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
        
    </body>
</html>
