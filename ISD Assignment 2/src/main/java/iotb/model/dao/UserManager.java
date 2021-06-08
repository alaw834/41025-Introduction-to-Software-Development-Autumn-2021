package iotb.model.dao;

import iotb.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class UserManager {

    private Statement statement;

    public UserManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    //Create Operation. Inserts into the usertable First Name,  Last Name, Email, Password, Phone Number
    public void addUser(String firstName, String lastName, String email, String password, String phonenum) throws SQLException, ParseException {
        String columns = "INSERT INTO USERTABLE(FIRSTNAME, LASTNAME, PASSWORD, PHONENUMBER, EMAILADDRESS)"; //Insert Part of SQL query
        String values = "VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + phonenum + "','" + email + "')"; //Values Part of SQL query
        statement.executeUpdate(columns + values); //Executes SQL query
    }

    //Read Operation - Reads user by email and password
    public User readUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM USERTABLE WHERE EMAILADDRESS = '" + email + "' AND PASSWORD = '" + password + "'"; //Select Statement
        ResultSet rs = statement.executeQuery(query); //Executes SQL query

        while (rs.next()) { //Iterate through result set 
            //Set each variable according to the location of the rs in the database
            Integer id = rs.getInt(1);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String emailaddress = rs.getString(4);
            String pass = rs.getString(5);
            String phonenum = rs.getString(6);

            return new User(id, firstname, lastname, emailaddress, pass, phonenum); //Return found user 
        }
        return null; //If no user is found, return null 
    }

    //Update Operation - Update user by id. 
    public void updateUser(int userID, String firstName, String lastName, String email, String password, String phonenum) throws SQLException, ParseException {
        String update = "UPDATE USERTABLE SET FIRSTNAME='" + firstName + "',LASTNAME='" + lastName + "',EMAILADDRESS='" + email + "',PASSWORD='" + password + "',PHONENUMBER='" + phonenum + "' WHERE USERID=" + userID + "";
        statement.executeUpdate(update); //Executes SQL query
    }

    //Delete Operation - Delete user by id
    public void deleteUser(int userID) throws SQLException {
        String delete = "DELETE FROM USERTABLE WHERE USERID= " + userID + ""; //Delete Statement 
        statement.executeUpdate(delete); //Executes SQL query
    }

    public int getID(String email, String password) throws SQLException {
        String query = "SELECT * FROM USERTABLE WHERE EMAILADDRESS = '" + email + "' AND PASSWORD = '" + password + "'"; //Select Statement
        ResultSet rs = statement.executeQuery(query); //Executes SQL query
        while (rs.next()) { //Find the result set that matches email and password and return the id
            Integer id = rs.getInt(1);
            return id;
        }
        return 0; //If no result is found, return 0
    }
}
