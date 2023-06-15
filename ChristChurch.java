/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChristChurch {
    private ArrayList<Hotel> ch;

    public ChristChurch() {
        ch = new ArrayList<Hotel>();
        Hotel hotel1 = new Hotel("The George", "Christchurch", 5, 400);
        Hotel hotel2 = new Hotel("Rydges Latimer", "Christchurch", 4, 300);
        Hotel hotel3 = new Hotel("Novotel Christchurch", "Christchurch", 4, 250);
        Hotel hotel4 = new Hotel("BreakFree on Cashel", "Christchurch", 3, 150);
        Hotel hotel5 = new Hotel("YHA Christchurch", "Christchurch", 2, 80);

        ch.add(hotel1);
        ch.add(hotel2);
        ch.add(hotel3);
        ch.add(hotel4);
        ch.add(hotel5);

        DBmanager dbManager = new DBmanager();
        dbManager.createChHotelsTable();

        for (int i = 0; i < ch.size(); i++) { // data insert
            Hotel hotel = ch.get(i);
            String sql = "INSERT INTO ChristChurchHotels (hotel_id, name, location, stars, cost) " +
                         "VALUES (" + (i + 1) + ", '" + hotel.getName() + "', '" + hotel.getLocation() + "', " +
                         hotel.getStars() + ", " + hotel.getCosts() + ")";
            dbManager.updateDB(sql);
        }

        dbManager.closeConnections();
    }

    public void displayHotels(JPanel panel) {
        DBmanager dbManager = new DBmanager();
        ResultSet resultSet = dbManager.queryDB("SELECT * FROM ChristChurchHotels");

        panel.setLayout(new GridLayout(ch.size(), 1)); // Set the panel layout

        try {
            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                int stars = resultSet.getInt("stars");
                int cost = resultSet.getInt("cost");

                Hotel hotel = new Hotel(name, location, stars, cost);
               

                JLabel label = new JLabel(hotel.toString()); // Create a JLabel to display hotel details
                panel.add(label); // Add the label to the panel
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dbManager.closeConnections();
        }
    }

    public ArrayList<Hotel> getChHotels() {
        return ch;
    }
}
