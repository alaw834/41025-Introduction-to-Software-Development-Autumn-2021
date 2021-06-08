<%@page import="iotb.controller.LoginValidator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
    </head>
    <body>    
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            session.setAttribute("existErr", "");
        %>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </div>

        <div id="title">
            <h1>Login to IoTBay</h1>
        </div>

        <div id="loginform">
            <form action="LoginServlet" method="post"> 
                <table id="loginTable">
                    <tr>    
                        <td  align="right">Email:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>" name="email" id="email" required/></td>    
                    </tr> 
                    <tr>    
                        <td  align="right">Password:</td>    
                        <td class="style1"><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>" name="password" id="password" required/></td>    
                    </tr>                      
                    <tr>                       
                        <td colspan="2" id="submitButton"><input class="button" type="submit" value="Login"></td>
                        <td class="style1"><span><%=(existErr != null ? existErr : "")%></span></td>  
                    </tr>
                </table>
            </form>
        </div>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
