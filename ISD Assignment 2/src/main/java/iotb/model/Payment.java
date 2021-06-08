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
public class Payment implements Serializable {
    
    private String paymentID;
    private String orderID;
    private String paymentType;
    private String paymentDate;

    public Payment(String paymentID, String orderID, String paymentType, String paymentDate) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    
    
    
}
