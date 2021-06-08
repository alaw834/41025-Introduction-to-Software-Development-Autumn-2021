/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alaw8
 */
public class StaffManager {

    private Statement statement;

    public StaffManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    //Create Operation 
    public void addStaff(int userID) throws SQLException {
        String columns = "INSERT INTO STAFFTABLE(USERID)"; //Insert statement of SQL query
        String values = "VALUES " + userID + ""; //Values statement of SQL query
        statement.executeUpdate(columns + values); //Execute SQL
    }

    //Read Operation - Read user by userid
    public Staff readStaff(int userID) throws SQLException {
        String query = "SELECT * FROM STAFFTABLE WHERE USERID = " + userID + ""; //Select statement of SQL query
        ResultSet rs = statement.executeQuery(query); //Execute SQL
        //Goes through result set and returns Staff if userID matches
        while (rs.next()) {
            Integer staffID = rs.getInt(1);

            return new Staff(userID, staffID);
        }
        return null; //If nothing is found, return null
    }

    //Update Operation - Update staff according to staffid
    public void updateStaff(int staffID, int userID) throws SQLException {
        String update = "UPDATE STAFFTABLE SET USERID='" + userID + "' WHERE STAFFID=" + staffID + ""; //Update statement of SQL query according to staffID
        statement.executeUpdate(update); //Execute SQL
    }

    //Delete Operation - Delete user by userid
    public void deleteStaff(int userID) throws SQLException {
        String delete = "DELETE FROM STAFFTABLE WHERE USERID=" + userID + ""; //Delete statement of SQL query according to user ID
        statement.executeUpdate(delete); //Execute SQL
    }
}
