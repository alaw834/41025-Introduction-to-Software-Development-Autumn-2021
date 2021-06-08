/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.CreditCard;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chris
 */
public class CreditCardManager {
    
    private Statement st;
    
    public CreditCardManager(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    // CREATE - requires an existing paymentID
    
    public void addCreditCard(int paymentID, String cardNumber, String expiryDate, String holderName, String cvv) throws SQLException, ParseException {
        String columns = "INSERT INTO CREDITCARDTABLE(PAYMENTID, CARDNUMBER, EXPIRYDATE, HOLDERNAME, CVV)";
        String values = "VALUES ("+paymentID+",'"+cardNumber+"','"+expiryDate+"','"+holderName+"','"+cvv+"')"; 
        st.executeUpdate(columns + values);
    }
    
    // READ - by card ID
    
    public CreditCard readCreditCard(int cardNumber)throws SQLException {
        String query = "SELECT * FROM CREDITCARDTABLE WHERE CARDID = "+cardNumber+"";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String paymentID = rs.getString(1);
            String cardID = rs.getString(2);
            String cardNo = rs.getString(3);
            String expiryDate = rs.getString(4);
            String holderName = rs.getString(5);
            String cvv = rs.getString(6);
            
            return new CreditCard(paymentID, cardID, cardNo, expiryDate, holderName, cvv);
        }
        
        return null;
    }
    
    // UPDATE - all credit card details by cardID
    
    public void updateCreditCard(int cardID, String newCardNumber, String expiryDate, String holderName, String cvv) throws SQLException, ParseException {
        
        
        //newCardNumber is the new card to be updated
        //oldCardNumber is used to search the existing credit card in the database
        
        String update = "UPDATE CREDITCARDTABLE SET CARDNUMBER = '"+newCardNumber+"',  EXPIRYDATE = '"+expiryDate+"',  HOLDERNAME = '"+holderName+"',  CVV = '"+cvv+"' WHERE CARDID="+cardID+"";
        st.executeUpdate(update);
    }
    
    // DELETE - by card ID
    
    public void deleteCreditCard(int cardID) throws SQLException {
        String delete = "DELETE FROM CREDITCARDTABLE WHERE CARDID = "+cardID+"";
        st.executeUpdate(delete);
    }
    
    // FETCH - all credit cards - outputs as HTML
    
    public String fetchCreditCard(int paymentID) throws SQLException {
        String query = "SELECT * FROM CREDITCARDTABLE WHERE PAYMENTID = "+paymentID+"";
        ResultSet rs = st.executeQuery(query);
        String allRecords = "";
        
        while (rs.next()) {
            
            String cardID = rs.getString("CARDID");
            String cardNo = rs.getString("CARDNUMBER");
            String expiryDate = rs.getString("EXPIRYDATE");
            String holderName = rs.getString("HOLDERNAME");
            String cvv = rs.getString("CVV");
            allRecords += "<tr><td>" + paymentID + "</td><td>" + cardID + "</td><td>" + cardNo + "</td><td>" + expiryDate + "</td><td>" + holderName + "</td><td>" + cvv + "</td></tr>";
            
        }
        
        return allRecords;
    }
}
