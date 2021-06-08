<%-- 
    Document   : staffregister
    Created on : 10/05/2021, 3:43:09 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Create a IoTBay Staff Account</title>
    </head>
    <%
        String fnameErr = (String) session.getAttribute("fnameErr");
        String lnameErr = (String) session.getAttribute("lnameErr");
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        session.setAttribute("existErr", "");
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="stafflogin.jsp">Staff Login</a></li>
            </ul>
        </div>

        <div id="title"> 
            <h1>Create a Staff Account</h1>
        </div>

        <div id="registerform">

            <form action="StaffRegisterServlet" method="post"> 

                <table id="registerTable">
                    <tr>    
                        <td  align="right">First Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(fnameErr != null ? fnameErr : "Enter First Name")%>" name="firstname" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Last Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(lnameErr != null ? lnameErr : "Enter Last Name")%>" name="lastname" required/></td>    
                    </tr>
                    <tr>    
                        <td  align="right">Email:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>" name="email" required/></td>    
                    </tr>                
                    <tr>    
                        <td  align="right">Password:</td>    
                        <td class="style1"><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>" name="password" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Phone Number</td>    
                        <td class="style1"><input type="tel" placeholder="<%=(phoneErr != null ? phoneErr : "Enter Phone Number")%>" name="phonenumber" placeholder="(+61)" required/></td>    
                    </tr>    
                    <tr>                       
                        <td colspan="2" id="submitButton"><input class="button" type="submit" value="Sign Up!"></td>
                        <td class="style1"><span><%=(existErr != null ? existErr : "")%></span></td>  
                    </tr>
                </table>
        </div>

        <input type="hidden" name="registration">
    </form>


    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</body>
<jsp:include page="/ConnectionServlet" flush="true" />
</html>
