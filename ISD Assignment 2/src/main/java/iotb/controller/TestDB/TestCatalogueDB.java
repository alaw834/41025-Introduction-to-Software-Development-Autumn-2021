package iotb.controller.TestDB;

import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.ProductManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class TestCatalogueDB {

    public static final Scanner in = new Scanner(System.in);
    public static ProductManager manager;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();
        manager = new ProductManager(con);
        char c;
        help();
        while ((c=readChoice()) != 'x'){
            switch(c){
                case 'c': addProduct();break;
                case 'r': listProduct();break;
                case 'u': updateProduct();break;
                case 'd': deleteProduct();break;
                default:help(); break;

            }
        }
    }

    public static void addProduct()throws SQLException, ParseException {
             System.out.print("Product Name: ");
             String name = in.nextLine();
             System.out.print("Product Description: ");
             String description = in.nextLine();
             System.out.print("Product Category: ");
             String category = in.nextLine();
             System.out.print("Product Price: ");
             String price = in.nextLine();
             System.out.print("Product Stock: ");
             String stock = in.nextLine();
             manager.addProduct(name, description, category, Float.parseFloat(price), Integer.parseInt(stock));
             System.out.println("A Product has been added to the database");   
        }
    
        public static void listProduct() throws SQLException{
             manager.listProduct();
        }
        
        public static void updateProduct() throws SQLException, ParseException{
             System.out.print("Enter Product ID to Update: ");
             String id = in.nextLine();
             System.out.print("Product Name: ");
             String name = in.nextLine();
             System.out.print("Product Description: ");
             String description = in.nextLine();
             System.out.print("Product Category: ");
             String category = in.nextLine();
             System.out.print("Product Price: ");
             String price = in.nextLine();
             System.out.print("Product Stock: ");
             String stock = in.nextLine();
             manager.updateProduct(Integer.parseInt(id), name, description, category, Float.parseFloat(price), Integer.parseInt(stock));
             System.out.println("A Product has been updated");
        }
        
        public static void deleteProduct() throws SQLException{
             System.out.print("Enter Product ID to Delete: ");
             String ProductID = in.nextLine();
             manager.deleteProduct(Integer.parseInt(ProductID));
             System.out.println("A Product has been deleted");
        }
        
        public static char readChoice(){
            System.out.print("Choices C/R/U/D/X: ");
            return in.nextLine().charAt(0);
        }
        
        public static void help(){
             System.out.println("Product CRUD operations: \n" + 
                     "C - Create Product\n" + 
                     "R - Read Product\n" + 
                     "U - Update Product\n" + 
                     "D - Delete Product\n"+ 
                     "X - Exit\n");
        }
    

    public static void readProduct() throws SQLException {
        System.out.print("Enter Product ID: ");
        String ProductID = in.nextLine();
        manager.readProduct(Integer.parseInt(ProductID));
    }
}
