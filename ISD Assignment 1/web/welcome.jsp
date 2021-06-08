<%-- 
    Document   : welcome
    Created on : 20/03/2021, 7:17:43 PM
    Author     : alaw8
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <% 
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phonenum");            
            String streetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
        %>
        <title>Welcome to IotBay <%=firstName%></title>
        <div id="navbar">
            <a href="index.html"> IoTBay </a>
            <span id="links"><a href="mainpage.jsp">Main Page</a><a href="logout.jsp">Logout</a></span>
        </div>
    </head>
    
    <body>
        <h1>Welcome to IoTBay</h1>
        <table class="table">            
            <tr><td>Name:</td><td><%=firstName%> <%=lastName%></td></tr>
            <tr><td>Email:</td><td><%=email%></td></tr>
            <tr><td>Password:</td><td><%=password%></td></tr>
            <tr><td>Phone:</td><td><%=phoneNumber%></td></tr>
            <tr><td>Gender:</td><td><%=gender%></td></tr>
            <tr><td>Date of Birth:</td><td><%=dob%></td></tr>      
            <tr><td>Street Number:</td><td><%=streetNumber%></td></tr>
            <tr><td>Street Name:</td><td><%=streetName%></td></tr>
            <tr><td>Post Code:</td><td><%=postCode%></td></tr>
        </table>
        <%
            Customer customer = new Customer(firstName,lastName,dob,gender, password, phoneNumber,email,streetNumber,streetName,postCode);
            session.setAttribute("customer", customer);
        %>
    </body>
</html>
