/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

import java.io.Serializable;

/**
 *
 * @author 1234
 */
public class CreditCard implements Serializable {
    
    private String paymentID;
    private String cardID;
    private String cardNumber;
    private String expiryDate;
    private String holderName;
    private String cvv;

    public CreditCard(String paymentID, String cardID, String cardNumber, String expiryDate, String holderName, String cvv) {
        this.paymentID = paymentID;
        this.cardID = cardID;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.holderName = holderName;
        this.cvv = cvv;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    
    
    
    
}
