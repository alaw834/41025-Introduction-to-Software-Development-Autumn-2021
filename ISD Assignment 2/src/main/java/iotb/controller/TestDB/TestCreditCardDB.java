/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.TestDB;

import iotb.model.CreditCard;
import iotb.model.dao.CreditCardManager;
import iotb.model.dao.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author 1234
 */
public class TestCreditCardDB {
    
    public static final Scanner in = new Scanner(System.in);
    public static CreditCardManager manager;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new CreditCardManager(con);
        
        char c;
        help();
        
        while ((c=readChoice()) != 'x') {
            switch(c) {
                case 'c': addCreditCard(); break;
                case 'r': readCreditCard(); break;
                case 'u': updateCreditCard(); break;
                case 'd': deleteCreditCard(); break;
                default: help(); break;
            }
        }
 
    }
    
    // CREATE - requires an existing paymentID to link the card to the payment
    
    public static void addCreditCard() throws SQLException, ParseException {
            System.out.println("PaymentID: ");
            String paymentID = in.nextLine();    
            System.out.println("Holder Name: ");
            String holderName = in.nextLine();    
            System.out.println("Card Number: ");
            String cardNumber = in.nextLine();
            System.out.println("Expiry Date: ");
            String expiryDate = in.nextLine();
            System.out.println("CVV: ");
            String cvv = in.nextLine();
            
            manager.addCreditCard(Integer.parseInt(paymentID), cardNumber, expiryDate, holderName, cvv); //Note: convert paymentID to int
            System.out.println("Credit Card successfully added");
        }
    
    // READ - by card number - says whether card exists
    
    public static void readCreditCard() throws SQLException {
        System.out.println("Enter card number: ");
        String cardNumber = in.nextLine();
        CreditCard creditCard = manager.readCreditCard(Integer.parseInt(cardNumber));
        String exists = (creditCard != null) ? "Credit card exists in the database" : "Credit card does not exist";
        System.out.println(exists);
    }
    
    // UPDATE - by card number
    
    public static void updateCreditCard() throws SQLException, ParseException {
        System.out.println("Card Number to update: ");
        String cardID = in.nextLine();
        System.out.println("Card Number: ");
        String newCardNumber = in.nextLine();
        System.out.println("Expiry Date: ");
        String expiryDate = in.nextLine();
        System.out.println("Holder Name: ");
        String holderName = in.nextLine();
        System.out.println("CVV: ");
        String cvv = in.nextLine();
            
        manager.updateCreditCard(Integer.parseInt(cardID), newCardNumber, expiryDate, holderName, cvv);
        System.out.println("Credit Card successfully updated");
    }
    
    // DELETE - by card number
    
    public static void deleteCreditCard() throws SQLException {
        System.out.println("Card Number: ");
        String cardNumber = in.nextLine();
        manager.deleteCreditCard(Integer.parseInt(cardNumber));
        System.out.println("Credit Card successfully deleted");
    }
    
    public static void help() {
        System.out.println("User CRUD operations: \n"
                + "C - Create credit card \n"
                + "R - Read credit card \n"
                + "U - Update credit card \n"
                + "D - Delete credit card \n"
                + "X - Exit \n");
    }
    
    public static char readChoice() {
        System.out.println("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }
}
