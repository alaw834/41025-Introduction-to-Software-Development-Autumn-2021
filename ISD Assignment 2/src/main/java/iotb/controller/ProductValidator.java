package iotb.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class ProductValidator implements Serializable {

    private String productIDPattern = "^(0|[1-9][0-9]*)$";
    private String productNamePattern = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$";
    private String productDescPattern = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$";
    private String productCatPattern = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$";
    private String productPricePattern = "[+-]?([0-9]*[.])?[0-9]+$";
    private String productStockPattern = "^(0|[1-9][0-9]*)$";
    
    public ProductValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateProductID(String id) {
        return validate(productIDPattern, id);
    }
    public boolean validateProductName(String productName) {
        return validate(productNamePattern, productName);
    }

    public boolean validateProductDesc(String productDesc) {
        return validate(productDescPattern, productDesc);
    }
    
    public boolean validateProductCat(String productCat) {
        return validate(productCatPattern, productCat);
    }
    
    public boolean validateProductPrice(String productPrice) {
        return validate(productPricePattern, productPrice);
    }
    
    public boolean validateProductStock(String productStock) {
        return validate(productStockPattern, productStock);
    }

    public void clear(HttpSession session){
        session.setAttribute("emailErr", "Enter Email");
        session.setAttribute("fnameErr", "Enter First Name");
        session.setAttribute("lnameErr", "Enter First Name");
        session.setAttribute("passErr", "Enter Password");
        session.setAttribute("dobErr", "Enter Date of Birth");
        session.setAttribute("phoneErr", "Enter Phone Number");
        session.setAttribute("streetNumErr", "Enter Street Number");
        session.setAttribute("streetNameErr", "Enter Street Name");
        session.setAttribute("postcodeErr", "Enter Postcode");
        session.setAttribute("existErr","");          
    }
}
