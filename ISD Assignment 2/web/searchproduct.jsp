<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>

<html>
    <head>
        <title>Landing</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
    <%
        String productNameErr = (String) session.getAttribute("productNameErr");
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
            <h1>Catalogue</h1>
        </div>

        <div id="registerform">
            <form action="SearchProductServlet" method="Post">

                    <table id="addProductTable">
                        <tr>    
                            <td  align="right">Product Name:</td>    
                            <td class="style1"><input type="text" placeholder="<%=(productNameErr != null ? productNameErr : "Enter Product Name")%>" name="productName" required/></td>    
                        </tr>
                        <tr>                       
                            <td colspan="2" id="submitButton"><input class="button" type="submit" value="Search Product"></td>
                        </tr>
                    </table>
                <input type="hidden" value="searchproduct">
            </form>
        </div>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
