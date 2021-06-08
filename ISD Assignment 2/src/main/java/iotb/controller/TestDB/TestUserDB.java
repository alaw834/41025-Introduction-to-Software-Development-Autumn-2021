package iotb.controller.TestDB;

import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.UserManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author alaw8
 */
public class TestUserDB {

    public static final Scanner in = new Scanner(System.in);
    public static UserManager manager;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new UserManager(con);
        char c;
        help();
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'c':
                    addUser();
                    break;
                case 'r':
                    readUser();
                    break;
                case 'u':
                    updateUser();
                    break;
                case 'd':
                    deleteUser();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    public static void addUser() throws SQLException, ParseException {
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        System.out.print("Phone Number: ");
        String phonenum = in.nextLine();
        manager.addUser(firstName, lastName, email, password, phonenum);
        System.out.println("A user has been added to the database");
    }

    public static void readUser() throws SQLException {
        System.out.print("Enter Email: ");
        String email = in.nextLine();
        System.out.print("Enter Password: ");
        String password = in.nextLine();
        manager.readUser(email, password);
    }

    public static void updateUser() throws SQLException, ParseException {
        System.out.print("Enter User ID to Update: ");
        String userID = in.nextLine();
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        System.out.print("Phone Number: ");
        String phonenum = in.nextLine();
        manager.updateUser(Integer.parseInt(userID), firstName, lastName, email, password, phonenum);
        System.out.println("A user has been updated");
    }

    public static void deleteUser() throws SQLException {
        System.out.print("Enter User ID to Delete: ");
        String userID = in.nextLine();
        manager.deleteUser(Integer.parseInt(userID));
        System.out.println("A user has been deleted");
    }

    public static char readChoice() {
        System.out.print("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }

    public static void help() {
        System.out.println("User CRUD operations: \n"
                + "C - Create User\n"
                + "R - Read User\n"
                + "U - Update User\n"
                + "D - Delete User\n"
                + "X - Exit\n");
    }
}
