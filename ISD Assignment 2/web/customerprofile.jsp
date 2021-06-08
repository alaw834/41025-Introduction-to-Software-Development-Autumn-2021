<%@page import="iotb.model.Customer"%>
<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Customer Page</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customer");
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="catalogue.jsp">Catalogue</a></li>
                <li><a href="main.jsp">Payment Options</a></li>
                <li><a href="updatecustomer.jsp">Edit Profile</a></li>
                <li><a href="logoutcustomer.jsp">Logout</a></li>
        </div>

        <div id="title">
            <h1>${user.fName}'s Page</h1>
        </div>

        <div id="info">
            <table id="infoTable">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>DOB</th>
                    <th>Street Number</th>
                    <th>Street Name</th>
                    <th>Post Code</th>
                </tr>
                <tr>
                    <td>
                        ${user.fName} ${user.lName}
                    </td>
                    <td>
                        ${user.emailAddress}
                    </td>
                    <td>
                        ${user.password}
                    </td>
                    <td>
                        ${user.phNumber}
                    </td>
                    <td>
                        ${customer.dob}
                    </td>
                    <td>
                        ${customer.streetNumber}
                    </td>
                    <td>
                        ${customer.streetName}
                    </td> 
                    <td>
                        ${customer.postCode}
                    </td>
                </tr>
            </table>
        </div>    

        <form action="DeleteCustomerServlet" method="Post">
            <input type="submit" value="Delete Account">
        </form>

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
