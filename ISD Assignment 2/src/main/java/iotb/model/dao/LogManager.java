package iotb.model.dao;

import iotb.model.AccessLog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author alaw8
 */
public class LogManager {

    private Statement statement;

    public LogManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    //Create Operation for customer. Adds who accessed, the date and the accesstype(Login/Logout)
    public void addCustomerLog(int userID, Date date, String accesstype) throws ParseException, SQLException {
        String columns = "INSERT INTO APPLICATIONLOGTABLE(USERID,ACCESSED,ACCESSTYPE)"; //Insert part of sql query
        String values = "VALUES (" + userID + ",'" + date + "','" + accesstype + "')"; //Values part of sql query
        statement.executeUpdate(columns + values); //Executes SQL query
    }

    //Create Operation for staff. Adds who accessed, the date and the accesstype(Login/Logout)
    public void addStaffLog(int staffID, Date date, String accesstype) throws ParseException, SQLException {
        String columns = "INSERT INTO APPLICATIONLOGTABLE(STAFFID, ACCESSED,ACCESSTYPE)"; //Insert part of sql query
        String values = "VALUES (" + staffID + ",'" + date + "','" + accesstype + "')"; //Values part of sql query
        statement.executeUpdate(columns + values);//Executes SQL query
    }

    //Create Operation for customer.
    public AccessLog readCustomerLog(int userID) throws SQLException {
        String query = "SELECT * FROM APPLICATIONLOGTABLE WHERE USERID = " + userID + ""; //Select part of sql query
        ResultSet rs = statement.executeQuery(query); //Execute query
        
        //Goes through result sets and sets variables to the results in the data base
        while (rs.next()) {
            Integer logid = rs.getInt(1);
            Integer userid = rs.getInt(2);
            Date accessdate = rs.getDate(4);
            String accesstype = rs.getString(5);
            return new AccessLog(logid, userid, null, accessdate, accesstype); //Returns the object
        }
        return null; //If there is no result, return null
    }

    //Create Operation for Staff.
    public AccessLog readStaffLog(int staffID) throws SQLException {
        String query = "SELECT * FROM APPLICATIONLOGTABLE WHERE USERID = " + staffID + ""; //Select part of sql query
        ResultSet rs = statement.executeQuery(query); //Execute query
        //Goes through result sets and sets variables to the results in the data base
        while (rs.next()) {
            Integer logid = rs.getInt(1);
            Integer staffid = rs.getInt(3);
            Date accessdate = rs.getDate(4);
            String accesstype = rs.getString(5);
            return new AccessLog(logid, null, staffid, accessdate, accesstype); //Returns the object
        }
        return null; //If there is no result, return null
    }

    //Delete Function. Deletes logs according to the user ID
    public void deleteLog(int ID) throws SQLException {
        String delete = "DELETE FROM APPLICATIONLOGTABLE WHERE USERID=" + ID + " OR STAFFID=" + ID + ""; //Delete part of sql query
        statement.executeUpdate(delete); //Execute query
    }

    //Read Function. Returns the log ID for a specific user
    public int getLogID(int ID) throws SQLException {
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID=" + ID + " OR STAFFID=" + ID + ""; //Select part of sql query
        ResultSet rs = statement.executeQuery(query); //Execute query
        //Goes through result sets and sets variables to the results in the data base
        while (rs.next()) {
            Integer id = rs.getInt(1);
            return id; //Returns the id of the found object
        }
        return 0; //If there is no result, return 0
    }
}
