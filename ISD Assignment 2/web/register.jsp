<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Create an IoTBay Account</title>
    </head>
    <%
        String fnameErr = (String) session.getAttribute("fnameErr");
        String lnameErr = (String) session.getAttribute("lnameErr");
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        String dobErr = (String) session.getAttribute("dobErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        String streetNumErr = (String) session.getAttribute("streetNumErr");
        String streetNameErr = (String) session.getAttribute("streetNameErr");
        String postcodeErr = (String) session.getAttribute("postcodeErr");
        session.setAttribute("existErr", "");
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </div>

        <div id="title"> 
            <h1>Create an IoTBay Account</h1>
        </div>

        <div id="registerform">

            <form action="RegisterServlet" method="post"> 

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
                        <td  align="right">Date of Birth:</td>
                        <td class="style1"><input type="text" placeholder="<%=(dobErr != null ? dobErr : "Enter Date of Birth")%>" name="dob" required/></td> 
                    </tr>
                    <tr>    
                        <td  align="right">Phone Number</td>    
                        <td class="style1"><input type="tel" placeholder="<%=(phoneErr != null ? phoneErr : "Enter Phone Number")%>" name="phonenumber" placeholder="(+61)" required/></td>    
                    </tr>    
                    <tr>    
                        <td  align="right">Street Number:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(streetNumErr != null ? streetNumErr : "Enter Street Number")%>" name="streetnumber" required/></td>    
                    </tr>
                    <tr>    
                        <td  align="right">Street Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(streetNameErr != null ? streetNameErr : "Enter Street Name")%>" name="streetname" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Post Code:</td>    
                        <td class="style1"><input inputmode="numeric" placeholder="<%=(postcodeErr != null ? postcodeErr : "Enter Post Code")%>" name="postcode" required/></td>    
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
