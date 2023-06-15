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

/**
 *
 * @author yuhwankim
 */
public class Auckland 
{
    private ArrayList<Hotel> auckland;
        
    public Auckland()
    {
        auckland = new ArrayList<Hotel>();
        Hotel hotel1 = new Hotel("ParkHyatt", "Auckland", 5, 350);
        Hotel hotel2 = new Hotel("Novotel", "Auckland", 4, 300);
        Hotel hotel3 = new Hotel("Cordis", "Auckland", 5, 600);
        Hotel hotel4 = new Hotel("FourSeasons", "Auckland", 4, 200);
        Hotel hotel5 = new Hotel("Backpackers", "Auckland", 1, 55);

        auckland.add(hotel1);
        auckland.add(hotel2);
        auckland.add(hotel3);
        auckland.add(hotel4);
        auckland.add(hotel5);

        DBmanager dbManager = new DBmanager();
        dbManager.createAucklandHotelsTable();

        for (int i = 0; i < auckland.size(); i++) { // data insert
            Hotel hotel = auckland.get(i);
            String sql = "INSERT INTO AucklandHotels(hotel_id, name, location, stars, cost) " +
                         "VALUES (" + (i + 1) + ", '" + hotel.getName() + "', '" + hotel.getLocation() + "', " +
                         hotel.getStars() + ", " + hotel.getCosts() + ")";
            dbManager.updateDB(sql);
        }

        dbManager.closeConnections();
    }

    public void displayHotels(JPanel panel) {
        DBmanager dbManager = new DBmanager();
        ResultSet resultSet = dbManager.queryDB("SELECT * FROM AucklandHotels");

        panel.setLayout(new GridLayout(auckland.size(), 1)); // Set the panel layout

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
    public ArrayList<Hotel> getAucklandHotels() {
        return auckland;
    }
}

