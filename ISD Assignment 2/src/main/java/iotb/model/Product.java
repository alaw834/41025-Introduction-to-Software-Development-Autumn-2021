package iotb.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private float productPrice;
    private int productStock;

    public Product(int productID, String productName, String productDescription, String productCategory, float productPrice, int productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
  
    public float getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    
    public int getProductStock() {

        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
