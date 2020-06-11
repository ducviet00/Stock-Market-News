package main.collectdata.DBquery;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String dbURL;

    public DBConnection(String dbname, String username, String password) {
        String pattern = "jdbc:sqlserver://localhost;databaseName=%s;user=%s;password=%s";
        this.dbURL = String.format(pattern, dbname, username, password);
    }

    public Connection connectDB() {
        try {
            Connection conn = DriverManager.getConnection(this.dbURL);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
            return conn;
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
            return null;
        }
    }

    public static void main(String[] args) {
        DBConnection db = new DBConnection("OOP", "sa", "1");
        db.connectDB();
    }
}
