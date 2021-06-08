<%-- 
    Document   : login
    Created on : 20/03/2021, 7:17:30 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Login to IoTBay</title>
        <div id="navbar">
            <a href="index.html"> IoTBay </a>
            <span id="links"> <a href="register.jsp">Register</a></span>
        </div>
    </head>
    <body>
        
        <h1 style="text-align: center">Log into IoTBay</h1>
        <form action="welcome.jsp" method="post"> 
            <table id="login"; cellspacing="5px" cellpadding="5%"; align="left">
                <tr>    
                    <td  align="right">Email:</td>    
                    <td class="style1"><input type="text" name="email" /></td>    
                </tr> 
                <tr>    
                    <td  align="right">Password:</td>    
                    <td class="style1"><input type="password" name="password"/></td>    
                </tr>   
                <tr>
                    <td> 
                    </td>
                    <td style="align-items: right">
                        <input class="button" type="submit" value="Login"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
