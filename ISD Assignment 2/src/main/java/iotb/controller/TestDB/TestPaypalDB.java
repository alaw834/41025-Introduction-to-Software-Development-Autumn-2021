/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.TestDB;

import iotb.model.Paypal;
import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.PaypalManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class TestPaypalDB {
    
    public static final Scanner in = new Scanner(System.in);
    public static PaypalManager manager;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new PaypalManager(con);
        
        char c;
        help();
        
        while ((c=readChoice()) != 'x') {
            switch(c) {
                case 'c': addPaypal(); break;
                case 'r': readPaypal(); break;
                case 'u': updatePaypal(); break;
                case 'd': deletePaypal(); break;
                default: help(); break;
            }
        }
 
    }
    
    // CREATE - requires an existing paymentID
    
    public static void addPaypal() throws SQLException, ParseException {
            System.out.println("PaymentID: ");
            String paymentID = in.nextLine();    
            System.out.println("PayPal Username: ");
            String paypalUsername = in.nextLine();
            System.out.println("PayPal Password: ");
            String paypalPassword = in.nextLine();   
            
            
            manager.addPaypal(Integer.parseInt(paymentID), paypalUsername, paypalPassword); //Note: convert orderID and paymentType to int
            System.out.println("PayPal successfully added");
        }
    
    // READ - by paypalID
    
    public static void readPaypal() throws SQLException {
        System.out.println("Enter PaypalID: ");
        String paypalID = in.nextLine();
        Paypal payment = manager.readPaypal(Integer.parseInt(paypalID));
        String exists = (payment != null) ? "PayPal exists in the database" : "PayPal does not exist";
        System.out.println(exists);
    }
    
    // UPDATE - by paypalID
    
    public static void updatePaypal() throws SQLException, ParseException {
        System.out.println("PayPal to be updated by paypalID: ");
        String paypalID = in.nextLine();
        System.out.println("PaymentID: ");
        String paymentID = in.nextLine();
        System.out.println("PayPal username: ");
        String paypalUsername = in.nextLine();
        System.out.println("PayPal password: ");
        String paypalPassword = in.nextLine();
            
        manager.updatePaypal(Integer.parseInt(paypalID), Integer.parseInt(paymentID), paypalUsername, paypalPassword);
        System.out.println("Paypal successfully updated");
    }
    
    // DELETE - by paypalID
    
    public static void deletePaypal() throws SQLException {
        System.out.println("Enter PayPalID: ");
        String paypalID = in.nextLine();
        manager.deletePaypal(Integer.parseInt(paypalID));
        System.out.println("PayPal successfully deleted");
    }
    
    
    
    public static void help() {
        System.out.println("User CRUD operations: \n"
                + "C - Create PayPal \n"
                + "R - Read PayPal \n"
                + "U - Update PayPal \n"
                + "D - Delete PayPal \n"
                + "X - Exit \n");
    }
    
    public static char readChoice() {
        System.out.println("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }
    
}
