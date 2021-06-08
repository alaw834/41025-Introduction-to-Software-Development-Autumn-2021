package iotb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector extends Database {

    public DatabaseConnector() throws ClassNotFoundException, SQLException {
        Class.forName(databaseDriver);
        super.con = DriverManager.getConnection(URL + database, databaseUser, databasePass);
    }

    public Connection connection() {
        return this.con;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }
}
