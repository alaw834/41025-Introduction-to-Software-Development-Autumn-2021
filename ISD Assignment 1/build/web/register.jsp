<%-- 
    Document   : register
    Created on : 20/03/2021, 7:17:37 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Register to IoTBay</title>
        <div id="navbar">
            <a href="index.html"> IoTBay </a>
            <span id="links"> <a href="login.jsp">Login</a></span>
        </div>
    </head>
    
    <body>
        <h1 style="text-align: center">Register for IoTBay</h1>
        
        <form action="welcome.jsp" method="post"> 
            <table id="register"; cellspacing="5px" cellpadding="5%"; align="left">
            <tr>    
                <td  align="right">First Name:</td>    
                <td class="style1"><input type="text" name="fname"/></td>    
            </tr>  
            <tr>    
                <td  align="right">Last Name:</td>    
                <td class="style1"><input type="text" name="lname"/></td>    
            </tr>
            <tr>    
                <td  align="right">Date of Birth:</td>    
                <td class="style1"><input type="date" name="dob"/></td>    
            </tr>
            <tr>    
                <td  align="right">Gender:</td>    
                <td class="style1">
                    <select id="gender" name="gender">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </td>    
            </tr> 
            <tr>    
                <td  align="right">Email:</td>    
                <td class="style1"><input type="text" name="email"/></td>    
            </tr> 
         
            <tr>    
                <td  align="right">Password:</td>    
                <td class="style1"><input type="password" name="password"/></td>    
            </tr>  
            <tr>    
                <td  align="right">Phone Number</td>    
                <td class="style1"><input type="tel" name="phonenum" placeholder="0123456789" <%--pattern="[0-9]{10}" required--%>/></td>    
            </tr>    
            <tr>    
                <td  align="right">Street Number:</td>    
                <td class="style1"><input type="number" name="streetnumber"/></td>    
            </tr>
            <tr>    
                <td  align="right">Street Name:</td>    
                <td class="style1"><input type="text" name="streetname"/></td>    
            </tr>  
            <tr>    
                <td  align="right">Post Code:</td>    
                <td class="style1"><input inputmode="numeric" name="postcode" <%--pattern="[0-9]{4}"--%>></td>    
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <input class="button" type="submit" value="Sign Up!"> 
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
