package iotb.controller.TestDB;

import java.util.Scanner;
import iotb.model.dao.StaffManager;
import iotb.model.dao.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author alaw8
 */
public class TestStaffDB {

    public static final Scanner in = new Scanner(System.in);
    public static StaffManager manager;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new StaffManager(con);
        char c;
        help();
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'c':
                    addStaff();
                    break;
                case 'r':
                    readStaff();
                    break;
                case 'u':
                    updateStaff();
                    break;
                case 'd':
                    deleteStaff();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    public static void addStaff() throws SQLException {
        System.out.print("UserID to make Staff: ");
        String userID = in.nextLine();
        manager.addStaff(Integer.parseInt(userID));
        System.out.println("A staff member has been added to the database");
    }

    public static void readStaff() throws SQLException {
        System.out.print("Enter Staff ID: ");
        String staffID = in.nextLine();
        manager.readStaff(Integer.parseInt(staffID));
    }

    public static void updateStaff() throws SQLException {
        System.out.print("Enter Staff ID: ");
        String staffID = in.nextLine();
        System.out.print("Enter User ID: ");
        String userID = in.nextLine();
        manager.updateStaff(Integer.parseInt(staffID), Integer.parseInt(userID));
        System.out.println("A staff member has been updated");
    }

    public static void deleteStaff() throws SQLException {
        System.out.print("Enter Staff ID to Delete: ");
        String staffID = in.nextLine();
        manager.deleteStaff(Integer.parseInt(staffID));
        System.out.println("A staff member has been deleted");
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
