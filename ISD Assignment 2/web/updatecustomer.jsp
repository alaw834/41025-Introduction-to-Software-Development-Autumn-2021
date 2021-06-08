<%@page import="iotb.model.Customer"%>
<%@page import="iotb.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customer");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Edit ${user.fName}'s Profile</title>
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
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="customerprofile.jsp">Your Profile</a></li>
                <li><a href="logoutcustomer.jsp">Logout</a></li>
            </ul>
        </div>

        <div id="title"> 
            <h1>Edit ${user.fName}'s Profile</h1>
        </div>

        <div id="registerform">
            <form action="UpdateCustomerServlet" method="post"> 
                <table id="updateTable">
                    <tr>    
                        <td  align="right">First Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(fnameErr != null ? fnameErr : "Enter First Name")%>" value="${user.fName}" name="firstname" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Last Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(lnameErr != null ? lnameErr : "Enter Last Name")%>" value="${user.lName}"name="lastname" required/></td>    
                    </tr>
                    <tr>    
                        <td  align="right">Email:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>" value="${user.emailAddress}" name="email" required/></td>    
                    </tr>                
                    <tr>    
                        <td  align="right">Password:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>" value="${user.password}" name="password" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Date of Birth:</td>
                        <td class="style1"><input type="text" placeholder="<%=(dobErr != null ? dobErr : "Enter Date of Birth (YYYY-DD-MM)")%>" value="${customer.dob}" name="dob" required/></td> 
                    </tr>
                    <tr>    
                        <td  align="right">Phone Number</td>    
                        <td class="style1"><input type="tel" placeholder="<%=(phoneErr != null ? phoneErr : "Enter Phone Number")%>" value="${user.phNumber}" name="phonenumber" placeholder="(+61)" required/></td>    
                    </tr>    
                    <tr>    
                        <td  align="right">Street Number:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(streetNumErr != null ? streetNumErr : "Enter Street Number")%>" value="${customer.streetNumber}" name="streetnumber" required/></td>    
                    </tr>
                    <tr>    
                        <td  align="right">Street Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(streetNameErr != null ? streetNameErr : "Enter Street Name")%>" value="${customer.streetName}" name="streetname" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Post Code:</td>    
                        <td class="style1"><input inputmode="numeric" placeholder="<%=(postcodeErr != null ? postcodeErr : "Enter Post Code")%>" value="${customer.postCode}" name="postcode" required/></td>    
                    </tr>
                    <tr>                       
                        <td colspan="2" id="submitButton"><input class="button" type="submit" value="Update Profile"></td>
                    </tr>
                </table>
        </div>

        <input type="hidden" name="update">
    </form>


    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</body>
<jsp:include page="/ConnectionServlet" flush="true" />
</html>
