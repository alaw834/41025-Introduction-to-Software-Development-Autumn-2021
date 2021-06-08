<%-- 
    Document   : logout
    Created on : 24/03/2021, 11:11:09 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Logging Out</title>
        <%
            String redirectURL = "index.html";
            session.invalidate();
            response.sendRedirect(redirectURL);
        %>
    </head>
    <body>
        <h1>Logging Out</h1>
    </body>
</html>
