/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Paypal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author chris
 */
public class PaypalManager {
    
    private Statement st;
    
    public PaypalManager(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    // CREATE - requires an existing paymentID
    
    public void addPaypal(int paymentID, String paypalUsername, String paypalPassword) throws SQLException, ParseException {
        String columns = "INSERT INTO PAYPALTABLE(PAYMENTID, PAYPALUSERNAME, PAYPALPASSWORD)";
        String values = "VALUES ("+paymentID+",'"+paypalUsername+"','"+paypalPassword+"')"; 
        st.executeUpdate(columns + values);
    }
    
    // READ - by paypalID
    
    public Paypal readPaypal(int searchpaypalID)throws SQLException {
        String query = "SELECT * FROM PAYPALTABLE WHERE PAYPALID = "+searchpaypalID+"";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String paypalID = rs.getString(1);
            String paymentID = rs.getString(2);
            String paypalUsername = rs.getString(3);
            String paypalPassword = rs.getString(4);
            
            
            return new Paypal(paypalID, paymentID, paypalUsername, paypalPassword);
        }
        
        return null;
    }
    
    // UPDATE - by paypalID
    
    public void updatePaypal(int paypalID, int paymentID, String paypalUsername, String paypalPassword) throws SQLException, ParseException {
        
        
        // Requires an existing paymentID to be assigned to
        
        String update = "UPDATE PAYPALTABLE SET PAYMENTID = "+paymentID+",  PAYPALUSERNAME = '"+paypalUsername+"', PAYPALPASSWORD = '"+paypalPassword+"' WHERE PAYPALID="+paypalID+"";
        st.executeUpdate(update);
    }
    
    // DELETE - by paypalID
    
    public void deletePaypal(int paypalID) throws SQLException {
        String delete = "DELETE FROM PAYPALTABLE WHERE PAYPALID = "+paypalID+"";
        st.executeUpdate(delete);
    }
    
    // FETCH - all paypal records - outputs as HTML
    
    public String fetchPaypal(int paymentID) throws SQLException {
        String query = "SELECT * FROM PAYPALTABLE WHERE PAYMENTID = "+paymentID+"";
        ResultSet rs = st.executeQuery(query);
        String allRecords = "";
        
        while (rs.next()) {
            
            String paypalID = rs.getString("PAYPALID");
            String paypalUsername = rs.getString("PAYPALUSERNAME");
            String paypalPassword = rs.getString("PAYPALPASSWORD");
            allRecords += "<tr><td>" + paypalID + "</td><td>" + paymentID + "</td><td>" + paypalUsername + "</td><td>" + paypalPassword +"</td></tr>";
            
        }
        
        return allRecords;
    }
}
