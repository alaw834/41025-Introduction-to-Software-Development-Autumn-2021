package iotb.controller.TestDB;

import java.util.Scanner;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author alaw8
 */
public class TestCustomerDB {

    public static final Scanner in = new Scanner(System.in);
    public static CustomerManager manager;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new CustomerManager(con);
        char c;
        help();
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'c':
                    addCustomer();
                    break;
                case 'r':
                    readCustomer();
                    break;
                case 'u':
                    updateCustomer();
                    break;
                case 'd':
                    deleteCustomer();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    public static void addCustomer() throws ParseException, SQLException {
        System.out.print("UserID: ");
        String userID = in.nextLine();
        System.out.print("DOB: ");
        String dob = in.nextLine();
        System.out.print("Street Number: ");
        String streetNum = in.nextLine();
        System.out.print("Street Name: ");
        String streetName = in.nextLine();
        System.out.print("Postcode: ");
        String postCode = in.nextLine();
        System.out.print("Registered: ");
        String registered = in.nextLine();
        manager.addCustomer(Integer.parseInt(userID), dob, Integer.parseInt(streetNum), streetName, Integer.parseInt(postCode), Boolean.parseBoolean(registered));
        System.out.println("A customer has been added to the database");
    }

    public static void readCustomer() throws SQLException {
        System.out.print("Enter Customer ID: ");
        String customerID = in.nextLine();
        manager.readCustomer(Integer.parseInt(customerID));
    }

    public static void updateCustomer() throws ParseException, SQLException {
        System.out.print("Enter Customer ID to Update: ");
        String customerID = in.nextLine();
        System.out.print("UserID: ");
        String userID = in.nextLine();
        System.out.print("DOB: ");
        String dob = in.nextLine();
        System.out.print("Street Number: ");
        String streetNum = in.nextLine();
        System.out.print("Street Name: ");
        String streetName = in.nextLine();
        System.out.print("Postcode: ");
        String postCode = in.nextLine();
        System.out.print("Registered: ");
        String registered = in.nextLine();
        manager.updateCustomer(Integer.parseInt(userID), Integer.parseInt(customerID), dob, Integer.parseInt(streetNum), streetName, Integer.parseInt(postCode), Boolean.parseBoolean(registered));
        System.out.println("A customer has been updated");
    }

    public static void deleteCustomer() throws SQLException {
        System.out.print("Enter Customer ID to Delete: ");
        String customerID = in.nextLine();
        manager.deleteCustomer(Integer.parseInt(customerID));
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
