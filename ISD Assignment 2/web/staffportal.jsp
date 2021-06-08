<%-- 
    Document   : staffportal
    Created on : 10/05/2021, 3:39:49 PM
    Author     : alaw8
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>

<html>
    <head>
        <title>Staff Portal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
    </head>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="stafflogin.jsp">Staff Login</a></li>
                <li><a href="staffregister.jsp">Staff Register</a></li>
            </ul>
        </div>

        <div id="homeTitle">
            <h1>IoTBay Staff</h1>
        </div>

        <div id="homeLogo">
            Logo
        </div>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
