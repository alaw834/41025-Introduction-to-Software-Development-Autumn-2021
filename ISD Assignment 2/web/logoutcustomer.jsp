
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Logout</title>
    </head>
    <body>
        <div id="title">
            <h1>Logout Confirmation</h1>
        </div>

        <div id="info">
            <h2>Are you sure you want to log out?</h2>
            <form action="customerprofile.jsp" method="Post">
                <input type="submit" value="Cancel">
            </form>
            <form action="LogoutServlet" method="Post">
                <input type="submit" value="Logout">
            </form>
        </div>

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
