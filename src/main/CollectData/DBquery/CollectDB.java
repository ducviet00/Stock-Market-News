package main.CollectData.DBquery;

import main.CollectData.ICollector;
import main.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CollectDB implements ICollector {
    private final DBConnection db;
    private final Connection conn;
    String columns = "Price, OpenPrice, High, Low, Vol, Change";
    public CollectDB(String dbname, String username, String password) {
        this.db = new DBConnection(dbname, username, password);
        this.conn = db.connectDB();
    }

    public List<Data> collectData(String table) {
        List<Data> collected = new ArrayList<>();
        try {
            String sqlquery = "SELECT tradeDate, " + columns + " From " + table;

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlquery);

            while (rs.next()) {
                Date date = rs.getDate("tradeDate");
                double price = rs.getDouble("Price");
                double open = rs.getDouble("OpenPrice");
                double high = rs.getDouble("High");
                double low = rs.getDouble("Low");
                double vol = rs.getDouble("Vol");
                double change = rs.getDouble("Change");
                Data temp = new Data(date, price, open, high, low, vol, change);
                collected.add(temp);
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
        List<Data> test = dc.collectData("VNIndex");
        System.out.println(test.get(test.size()-1));
        System.out.println(test.size());

    }
}

