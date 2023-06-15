/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ndg0757
 */
public class BookingHistory extends JFrame{
    public static final int height = 400;
    public static final int width = 400;
    private JButton searchButton;
    private JButton checkButton;
    private static final String URL = "jdbc:derby://localhost:1527/Hotel";
    private static final String USER_NAME = "pdc"; 
    private static final String PASSWORD = "pdc"; 
  
    
    public BookingHistory(String userName)
    {
        this.setTitle("Booking Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);   
        this.setLayout(null);
        
        JLabel label = new JLabel("Your booking is : ");
        label.setBounds(150,-30,300,100);
        this.add(label);
        
        displayBookingHistory(userName);

        this.setVisible(true);
    }

   private void displayBookingHistory(String userName) {
    DBmanager dbManager = new DBmanager();
    Connection conn = dbManager.getConnection();

    try {
        String sql = "SELECT * FROM GUESTS WHERE FIRST_NAME = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, userName);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String bookingInfo = resultSet.getString("BOOKING_INFO");
                    JLabel bookingLabel = new JLabel(bookingInfo);
                    bookingLabel.setBounds(50, 50, 300, 30);
                    this.add(bookingLabel);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "An error occurred while retrieving booking history.");
    } finally {
        dbManager.closeConnections();
    }
   }
}
