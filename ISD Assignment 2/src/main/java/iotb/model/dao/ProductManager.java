package iotb.model.dao;

import iotb.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private Statement statement;

    public ProductManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    public void addProduct(String productName, String productDesc, String productCat, float productPrice, int productStock) throws SQLException, ParseException {
        String columns = "INSERT INTO PRODUCTTABLE(PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCTSTOCK)";
        String values = "VALUES ('" + productName + "','" + productDesc + "','" + productCat + "'," + productPrice + "," + productStock + ")";
        statement.executeUpdate(columns + values);
    }

    public Product readProduct(int productID) throws SQLException {
        String query = "SELECT * FROM PRODUCTTABLE WHERE PRODUCTID = " + productID + "";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            String category = rs.getString(4);
            String price = rs.getString(5);
            String stock = rs.getString(6);
//        System.out.println("Product ID: " + id);
//        System.out.println("Product Name: " + name);
//        System.out.println("Product Description: " + description);
//        System.out.println("Product Category: " + category);
//        System.out.println("Product Price: " + price);
//        System.out.println("Product Stock: " + stock);

            return new Product(Integer.parseInt(id), name, description, category, Float.parseFloat(price), Integer.parseInt(stock));
        }
        return null;
    }
    
    public ArrayList<Product> listProduct() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM PRODUCTTABLE ORDER BY PRODUCTID";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Product newProduct = new Product(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),rs.getString(4), Float.parseFloat(rs.getString(5)), Integer.parseInt(rs.getString(6)));
            System.out.println(rs.getString(2));
            products.add(newProduct);
        }
        return products;
    }

    public void updateProduct(int productID, String productName, String productDesc, String productCat, float productPrice, int productStock) throws SQLException {
        String update = "UPDATE PRODUCTTABLE SET PRODUCTNAME='" + productName + "',PRODUCTDESCRIPTION='" + productDesc + "',PRODUCTCATEGORY='" + productCat + "',PRODUCTPRICE=" + productPrice + ",PRODUCTSTOCK=" + productStock + " WHERE PRODUCTID=" + productID + "";
        statement.executeUpdate(update);
    }

    public void deleteProduct(int productID) throws SQLException {
        String delete = "DELETE FROM PRODUCTTABLE WHERE PRODUCTID=" + productID + "";
        statement.executeUpdate(delete);
    }

    public int getID(String productName) throws SQLException {
        String query = "SELECT * FROM PRODUCTTABLE WHERE PRODUCTNAME = '" + productName + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Integer id = rs.getInt(1);
            return id;
        }
        return 0;
    }
}
