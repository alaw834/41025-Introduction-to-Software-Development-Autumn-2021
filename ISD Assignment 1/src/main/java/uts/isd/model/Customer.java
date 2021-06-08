package uts.isd.model;

/**
 *
 * @author alaw8
 */
public class Customer {
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private String password;
    private String phNumber;
    private String emailAddress;
    private String streetNumber;
    private String streetName;
    private String postCode;

    public Customer(String fName, String lName, String dob, String gender, String password, String phNumber, String emailAddress, String streetNumber, String streetName, String postCode) {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
        this.phNumber = phNumber;
        this.emailAddress = emailAddress;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postCode = postCode;
    }
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    
}
