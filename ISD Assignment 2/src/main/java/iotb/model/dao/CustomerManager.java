/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alaw8
 */
public class CustomerManager {

    private Statement statement;

    public CustomerManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    //Create Operation. Adds Customer and their dob, street num, street name, post code and if theyre registered
    public void addCustomer(int userID, String dob, int streetNum, String streetName, int postCode, boolean registered) throws ParseException, SQLException {
        String columns = "INSERT INTO CUSTOMERTABLE(USERID, DOB, STREETNUMBER, STREETNAME, POSTCODE, REGISTERED)"; //Insert statement for SQL
        Date d = DateFormat.getDateInstance().parse(dob); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d); //Formats date to be added to database
        String values = "VALUES (" + userID + ",'" + strDate + "'," + streetNum + ",'" + streetName + "'," + postCode + "," + registered + ")"; //Values statement for SQL
        statement.executeUpdate(columns + values); //Executes SQL
    }

    //Read Operation. Reads customer according to the user id passed into it 
    public Customer readCustomer(int userID) throws SQLException {
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID = " + userID + ""; //Select statement for SQLs
        ResultSet rs = statement.executeQuery(query); //Executes SQL

        //Goes through result set and sets variables according to database
        while (rs.next()) {
            Integer customerid = rs.getInt(1);
            Integer userid = rs.getInt(2);
            Date dob = rs.getDate(3);
            Integer streetnumber = rs.getInt(4);
            String streetname = rs.getString(5);
            Integer postcode = rs.getInt(6);
            Boolean registered = rs.getBoolean(7);

            return new Customer(userid, customerid, dob, streetnumber, streetname, postcode, registered); //Returns the whole customer
        }
        return null; //Returns null if no customer is found 
    }

    //Update Function. Updates Customer according to the user id. Can update Dob, street num, street name, postcode and if theyre registered
    public void updateCustomer(int userID, int customerID, String dob, int streetNumber, String streetName, int postCode, Boolean registered) throws SQLException, ParseException {
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d); //Formats date to be added to database
        String update = "UPDATE CUSTOMERTABLE SET USERID=" + userID + ",DOB='" + strDate + "',STREETNUMBER=" + streetNumber + ",STREETNAME='" + streetName + "',POSTCODE=" + postCode + ",REGISTERED=" + registered + " WHERE CUSTOMERID= " + customerID + " ";
        statement.executeUpdate(update); //Executes SQL
    }

    //Delete Function. Deletes customer according to user id
    public void deleteCustomer(int userID) throws SQLException {
        String delete = "DELETE FROM CUSTOMERTABLE WHERE USERID=" + userID + ""; //Delete statement for SQL 
        statement.executeUpdate(delete); //Executes SQL
    }
    
    //Delete Function. Deletes Order according to user id
    public void deleteOrder(int userID) throws SQLException {
        String delete = "DELETE FROM ORDERTABLE WHERE CUSTOMERID= " + userID + ""; //Delete statement for SQL 
        statement.executeUpdate(delete); //Executes SQL
    }

    //Read Function. Gets user id of the customer
    public int getID(int userID) throws SQLException {
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID = " + userID + "";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer id = rs.getInt(1);
            return id;
        }
        return 0;
    }
}
