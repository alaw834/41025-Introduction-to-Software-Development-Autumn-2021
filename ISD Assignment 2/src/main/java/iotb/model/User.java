package iotb.model;

import java.io.Serializable;

public class User implements Serializable {

    private Integer userID;
    private String fName;
    private String lName;
    private String emailAddress;
    private String password;
    private String phNumber;

    public User(Integer userID, String fName, String lName, String emailAddress, String password, String phNumber) { //Returns User
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phNumber = phNumber;
    }

    public Integer getUserID() { //Returns UserID associated to the User
        return userID;
    }

    public void setUserID(Integer userID) { //Sets UserID to new UserID passed to it
        this.userID = userID;
    }

    public String getfName() { //Returns First name of the user
        return fName;
    }

    public void setfName(String fName) { //Sets First name of user to name passed to it
        this.fName = fName;
    }

    public String getlName() { //Returns Last name of the user
        return lName;
    }

    public void setlName(String lName) { //Sets Last name of user to name passed to it
        this.lName = lName;
    }

    public String getEmailAddress() { //Returns email address of the user
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) { //Sets email address to new email address passed to it
        this.emailAddress = emailAddress;
    }

    public String getPassword() { //Returns password of the user
        return password;
    }

    public void setPassword(String password) { //Sets password to new password passed to it
        this.password = password;
    }

    public String getPhNumber() { //Returns Phone number of user 
        return phNumber;
    }

    public void setPhNumber(String phNumber) { //Sets Phone number to new phone number passed to it
        this.phNumber = phNumber;
    }

}
