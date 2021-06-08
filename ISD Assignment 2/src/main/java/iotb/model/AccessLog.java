package iotb.model;

import java.util.Date;

/**
 *
 * @author alaw8
 */
public class AccessLog {

    private Integer logID;
    private Integer userID;
    private Integer staffID;
    private Date accessDate;
    private String accessType;

    public AccessLog(Integer logID, Integer userID, Integer staffID, Date accessDate, String accessType) {
        this.logID = logID;
        this.userID = userID;
        this.staffID = staffID;
        this.accessDate = accessDate;
        this.accessType = accessType;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

}
