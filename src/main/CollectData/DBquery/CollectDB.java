package main.CollectData.DBquery;

import main.CollectData.ICollector;
import main.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CollectDB implements ICollector {
    private final DBConnection db;
    private final Connection conn;
    String columns = "Price, OpenPrice, High, Low, Vol, Change";
    public CollectDB(String dbname, String username, String password) {
        this.db = new DBConnection(dbname, username, password);
        this.conn = db.connectDB();
    }

    public Map<String, Data> collectData(String table) {
        Map<String, Data> collected = new HashMap<>();
        try {
            String sqlquery = "SELECT tradeDate, " + columns + " From " + table;

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlquery);

            while (rs.next()) {
                String date = rs.getDate("tradeDate").toString();
                double price = rs.getDouble("Price");
                double open = rs.getDouble("OpenPrice");
                double high = rs.getDouble("High");
                double low = rs.getDouble("Low");
                double vol = rs.getDouble("Vol");
                double change = rs.getDouble("Change");
                Data temp = new Data(price, open, high, low, vol, change);
                collected.put(date, temp);
            }

            System.out.println("Collected: " + columns);
            rs.close();
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Cannot query sql: " + ex);
        }
        try {
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("Cannot close the connection: " + ex);
        }
        return collected;
    }


    public static void main(String[] args) {
        CollectDB dc = new CollectDB("OOP", "sa", "1");
        Map<String, Data> test = dc.collectData("VNIndex");
        System.out.println(test.get("2020-04-21"));
        System.out.println(test.size());

    }
}

