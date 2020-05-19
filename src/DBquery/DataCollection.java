package DBquery;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.Data;

public class DataCollection {

    private DBConnection db;
    private Connection conn;
    String columns = "Price, OpenPrice, High, Low, Vol, Change";
    public DataCollection(String dbname, String username, String password) {
        this.db = new DBConnection(dbname, username, password);
        this.conn = db.connectDB();
    }

    public Map<String, Data> collectData(String table) {
        try {
            Map<String, Data> collected = new HashMap<>();
            String sqlquery = "SELECT Top(10) tradeDate, " + columns + " From " + table;

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlquery);

            while (rs.next()) {
                String date = rs.getString("tradeDate");
                double price = rs.getDouble("Price");
                double open = rs.getDouble("OpenPrice");
                double low = rs.getDouble("Low");
                double high = rs.getDouble("High");
                double vol = rs.getDouble("Vol");
                double change = rs.getDouble("Change");
                Data temp = new Data(price, open, low, high, vol, change);
                collected.put(date, temp);
            }

            System.out.println("Collected: " + columns);
            rs.close();
            statement.close();

            return collected;
        }
        catch (SQLException ex) {
            System.out.println("Cannot query sql: " + ex);
            return null;
        }
    }
    public void closeConnection() {
        try {
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("Cannot close the connection: " + ex);
        }
    }
}

