/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author yuhwankim
 */
public class ChristChurch 
{
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
    }
    public void displayHotels(javax.swing.JPanel panel) {
        panel.setLayout(new GridLayout(ch.size(), 1)); // Set the panel layout

        for (Hotel hotel : ch) {
            JLabel label = new JLabel(hotel.toString()); // Create a JLabel to display hotel details
            panel.add(label); // Add the label to the panel
        }
    }
    public ArrayList<Hotel> getChHotels() {
        return ch;
    }
}
