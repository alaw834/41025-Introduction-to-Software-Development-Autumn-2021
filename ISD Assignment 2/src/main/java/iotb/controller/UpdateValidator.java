/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alaw8
 */
public class UpdateValidator {
    private String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    private String namePattern = "^[A-Z][a-zA-Z]+$";
    private String passwordPattern = "[A-Za-z0-9]{4,}";
    private String dobPattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private String numberPattern = "^(0|[1-9][0-9]*)$";
    private String phonenumPattern = "^[0-9]{10}|[0-9]{6}$";
    private String streetNamePattern = "^[a-zA-Z0-9_ ]*$";
    private String postcodePattern = "^[0-9]{4}$";
    
    public UpdateValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }
    
    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateDob(String dob) {
        return validate(dobPattern, dob);
    }
    
    public boolean validateNum(String number) {
        return validate(numberPattern, number);
    }
    
    public boolean validatePhoneNum(String phnumber){
        return validate(phonenumPattern,phnumber);
    }
    
    public boolean validatestreetName(String streetName){
        return validate(streetNamePattern,streetName);
    }
    
    public boolean validatePostCode(String postcode) {
        return validate(postcodePattern, postcode);
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
