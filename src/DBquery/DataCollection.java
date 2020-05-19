import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
public class DataCollection {

    private DBConnection db;
    private Connection conn;

    public DataCollection(String dbname, String username, String password) {
        this.db = new DBConnection(dbname, username, password);
        this.conn = db.connectDB();
    }

    public ArrayList<Data> collectData(String column, String table) {
        try {
            ArrayList<Data> collection = new ArrayList<>();
            String sqlquery = "SELECT Top(10) tradeDate, " + column + " From " + table;

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlquery);

            while (rs.next()) {
                String date = rs.getString("tradeDate");
                double data = rs.getDouble(column);
                Data temp = new Data(data, date);
                collection.add(temp);
            }

            System.out.println("Collected: " + column);
            rs.close();
            statement.close();

            return collection;
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

