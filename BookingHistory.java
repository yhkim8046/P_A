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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ndg0757
 */
public final class BookingHistory extends JFrame{
    public static final int height = 400;
    public static final int width = 400;
    private JButton searchButton;
    private JButton checkButton;
    private static final String URL = "jdbc:derby://localhost:1527/Hotel";
    private static final String USER_NAME = "pdc"; 
    private static final String PASSWORD = "pdc"; 
    private String userName;
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    
    public BookingHistory()
    {
        this.userName = "";
        this.setTitle("Booking Check");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);   
        this.setLayout(null);
        
        JLabel label = new JLabel("Your booking is : ");
        label.setBounds(0,-30,400,100);
        this.add(label);
        
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menuitem
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new CheckFrame.exit());

        this.setVisible(true);
    }

   public void displayBookingHistory(String userName) {
    DBmanager dbManager = new DBmanager();
    Connection conn = dbManager.getConnection();
    boolean existed = false;

    try {
        String sql = "SELECT * FROM GUESTS WHERE FIRST_NAME = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, userName);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    existed = true;
                    String lastName = resultSet.getString("LAST_NAME");
                    String firstName = resultSet.getString("FIRST_NAME");
                    String email = resultSet.getString("EMAIL");
                    // Retrieve other columns as needed

                    // Create a label to display the booking information
                    JLabel bookingLabel = new JLabel("Last Name: " + lastName + ", First Name: " + firstName + ", Email: " + email);
                    bookingLabel.setBounds(0, 50, 400, 30);
                    this.add(bookingLabel);
                }
            }
        }
        if (!existed) {
            JOptionPane.showMessageDialog(this, "Failed to find booking history.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "An error occurred while retrieving booking history.");
    } finally {
        dbManager.closeConnections();
    }
    }


   
   public void setUserName(String userName)
   {
       this.userName = userName;
   }
   public String getUserName()
   {
       return this.userName;
   }
}
