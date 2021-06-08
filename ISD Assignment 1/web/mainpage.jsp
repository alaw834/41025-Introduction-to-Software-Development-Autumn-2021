<%-- 
    Document   : mainpage
    Created on : 28/03/2021, 10:46:11 PM
    Author     : alaw8
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Main Page</title>
        <div id="navbar">
            <a href="index.html"> IoTBay </a>
            <span id="links"> <a href="logout.jsp">Logout</a></span>
        </div>
    </head>
    
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <div id="title">
            <h1>IoTBay MainPage</h1>
        </div>
            
        <div id="prebody">
            <h2> Hi, ${customer.fName} </h2>
        </div>
        
        <div id="body">
            <table style="width:75%">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date of Birth</th>
                    <th>Gender</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>Street Number</th>
                    <th>Street Name</th>
                    <th>Post Code</th>
                    
                </tr>
                <tr style="text-align:center;">
                    <td>
                        ${customer.fName} ${customer.lName}
                    </td>
                    <td>
                        ${customer.emailAddress}
                    </td>
                    <td>
                        ${customer.dob}
                    </td>
                    <td>
                        ${customer.gender}
                    </td> 
                    <td>
                        ${customer.password}
                    </td>
                    <td>
                        ${customer.phNumber}
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
    </body>
</html>
