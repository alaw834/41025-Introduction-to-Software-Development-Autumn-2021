package iotb.model;

import java.util.Date;

public class Customer {

    private Integer userID;
    private Integer customerID;
    private Date dob;
    private Integer streetNumber;
    private String streetName;
    private Integer postCode;
    private Boolean registered;

    public Customer(Integer userID, Integer customerID, Date dob, Integer streetNumber, String streetName, Integer postCode, Boolean registered) { //Returns customer
        this.userID = userID;
        this.customerID = customerID;
        this.dob = dob;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postCode = postCode;
        this.registered = registered;
    }

    public Integer getUserID() { //Returns userID of the Customer
        return userID;
    }

    public void setUserID(Integer userID) { //Sets User ID to new userID passed to it
        this.userID = userID;
    }

    public Integer getCustomerID() { //Returns CustomerID of the Customer
        return customerID;
    }

    public void setCustomerID(Integer customerID) { //Sets Customer ID to new CustomerID passed to it
        this.customerID = customerID;
    }

    public Date getDob() { //Returns dob of the Customer
        return dob;
    }

    public void setDob(Date dob) { //Sets DOB to new CustomerID passed to it
        this.dob = dob;
    }

    public Integer getStreetNumber() { //Returns street number of the Customer
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) { //Sets street number to new street number passed to it
        this.streetNumber = streetNumber;
    }

    public String getStreetName() { //Returns street name of the Customer
        return streetName;
    }

    public void setStreetName(String streetName) { //Sets street name to new street name passed to it
        this.streetName = streetName;
    }

    public Integer getPostCode() { //Returns post code of the Customer
        return postCode;
    }

    public void setPostCode(Integer postCode) { //Sets post code to new post code passed to it
        this.postCode = postCode;
    }

    public Boolean getRegistered() { //Returns registered state of the customer
        return registered;
    }

    public void setRegistered(Boolean registered) { //Returns registered state of the customer to what is passed to it
        this.registered = registered;
    }

}
