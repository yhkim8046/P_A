/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.awt.GridLayout;
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
        Hotel hotel1 = new Hotel("ParkHyatt", "Auckland",5,350);
        Hotel hotel2 = new Hotel("Novotel", "Auckland",4,300);
        Hotel hotel3 = new Hotel("Cordis","Auckland",5,600);
        Hotel hotel4 = new Hotel("FourSeasons", "Auckland",4,200);
        Hotel hotel5 = new Hotel("Backpackers","Auckland",1,55);
        
        
        auckland = new ArrayList<Hotel>();
        
        auckland.add(hotel1);
        auckland.add(hotel2);
        auckland.add(hotel3);
        auckland.add(hotel4);
        auckland.add(hotel5);
        
        
    }
    public void displayHotels(JPanel panel) {
        panel.setLayout(new GridLayout(auckland.size(), 1)); // Set the panel layout

        for (Hotel hotel : auckland) {
            JLabel label = new JLabel(hotel.toString()); // Create a JLabel to display hotel details
            panel.add(label); // Add the label to the panel
        }
    }
    public ArrayList<Hotel> getAucklandHotels() {
        return auckland;
    }
}

