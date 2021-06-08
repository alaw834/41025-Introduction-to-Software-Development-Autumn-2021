/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

/**
 *
 * @author 1234
 */
public class Paypal {
    
    private String paypalID;
    private String paymentID;
    private String paypalUsername;
    private String paypalPassword;

    public Paypal(String paypalID, String paymentID, String paypalUsername, String paypalPassword) {
        this.paypalID = paypalID;
        this.paymentID = paymentID;
        this.paypalUsername = paypalUsername;
        this.paypalPassword = paypalPassword;
    }

    public String getPaypalID() {
        return paypalID;
    }

    public void setPaypalID(String paypalID) {
        this.paypalID = paypalID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaypalUsername() {
        return paypalUsername;
    }

    public void setPaypalUsername(String paypalUsername) {
        this.paypalUsername = paypalUsername;
    }

    public String getPaypalPassword() {
        return paypalPassword;
    }

    public void setPaypalPassword(String paypalPassword) {
        this.paypalPassword = paypalPassword;
    }
    
    
    
}
