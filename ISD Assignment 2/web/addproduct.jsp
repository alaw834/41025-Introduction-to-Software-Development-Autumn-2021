<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Add Product</title>
    </head>
    <%
        String productNameErr = (String) session.getAttribute("productNameErr");
        String productDescErr = (String) session.getAttribute("productDescErr");
        String productCatErr = (String) session.getAttribute("productCatErr");
        String productPriceErr = (String) session.getAttribute("productPriceErr");
        String productStockErr = (String) session.getAttribute("productStockErr");
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="catalogue.jsp">Catalogue</a></li>
                    <%
                        if (session.getAttribute("user") == null) {
                    %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="staffportal.jsp">Staff Portal</a></li>
                    <%
                    } else if (session.getAttribute("customer") != null) {
                    %>
                <li><a href="customerprofile.jsp">Your Profile</a></li>
                <li><a href="logoutcustomer.jsp">Logout</a></li>
                    <%
                    } else if (session.getAttribute("staff") != null) {
                    %>
                <li><a href="staffhome.jsp">Your Profile</a></li>
                <li><a href="logoutstaff.jsp">Logout</a></li>
                    <%
                        }
                    %>
            </ul>
        </div>

        <div id="title"> 
            <h1>Add a product</h1>
        </div>
        <div id="registerform">
            <form action="AddProductServlet" method="post"> 
                <table id="addProductTable">
                    <tr>    
                        <td  align="right">Product Name:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productNameErr != null ? productNameErr : "Enter Product Name")%>" name="productName" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Product Description:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productDescErr != null ? productDescErr : "Enter Product Description")%>" name="productDesc" required/></td>    
                    </tr>  
                    <tr>    
                        <td  align="right">Product Category:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productCatErr != null ? productCatErr : "Enter Product Category")%>" name="productCat" required/></td>    
                    </tr>
                    <tr>    
                        <td  align="right">Product Price:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productPriceErr != null ? productPriceErr : "Enter Product Price")%>" name="productPrice" required/></td>    
                    </tr>                
                    <tr>    
                        <td  align="right">Product Stock:</td>    
                        <td class="style1"><input type="text" placeholder="<%=(productStockErr != null ? productStockErr : "Enter Product Stock")%>" name="productStock" required/></td>    
                    </tr>                       
                    <td colspan="2" id="submitButton"><input class="button" type="submit" value="Add Product"></td>
                    </tr>
                </table>
        </div>
        <input type="hidden" name="addproduct">
    </form>

    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</body>
<jsp:include page="/ConnectionServlet" flush="true" />
</html>
