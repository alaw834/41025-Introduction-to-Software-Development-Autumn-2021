<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Staff Home</title>
    </head>


    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="updatestaff.jsp">Edit Profile</a></li>
                <li><a href="logoutstaff.jsp">Logout</a></li>
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
                </tr>
            </table>
        </div>    

        <form action="DeleteStaffServlet" method="Post">
            <input type="submit" value="Delete Account">
        </form>

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>