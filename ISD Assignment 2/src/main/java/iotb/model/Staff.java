package iotb.model;

public class Staff {

    private Integer userID;
    private Integer staffID;

    public Staff(Integer userID, Integer staffID) { //Returns UserID and its associated Staff ID
        this.userID = userID;
        this.staffID = staffID;
    }

    public Integer getUserID() { //Gets UserID associated to the staff member
        return userID;
    }

    public void setUserID(Integer userID) { //Sets UserID to the new UserID passed to it
        this.userID = userID;
    }

    public Integer getStaffID() { //Gets StaffID associated to the staff member
        return staffID;
    }

    public void setStaffID(Integer staffID) { //Sets StaffID to the new StaffID passed to it
        this.staffID = staffID;
    }

}
