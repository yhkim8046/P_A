/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ndg0757
 */
public class DBmanager {
    private static final String URL = "jdbc:derby://localhost:1527/Hotel";
    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
  
    Connection conn;

    public DBmanager() {
        establishConnection();
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void createGuestsTable() {
    String tableName = "GUESTS";

    // Check if the table already exists
    try {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName.toUpperCase(), null);

        if (resultSet.next()) {
            System.out.println("Table '" + tableName + "' already exists in Schema 'PDC'.");
            return;
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return;
    }

    // Create the table if it doesn't exist
    String sql = "CREATE TABLE " + tableName + " (" +
        "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY," +
        "LAST_NAME VARCHAR(100)," +
        "FIRST_NAME VARCHAR(100)," +
        "EMAIL VARCHAR(100)," +
        "MOBILE VARCHAR(20)," +
        "CHECK_IN_DATE DATE," +
        "CHECK_OUT_DATE DATE," +
        "TOTAL_PRICE DECIMAL(10, 2)," +
        "SELECTED_HOTEL VARCHAR(100)" +
        ")";

    updateDB(sql);
}




    
    //Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



