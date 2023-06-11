/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel; 

/**
 *
 * @author yuhwankim
 */
public class SearchFrame extends JFrame
{
    private int height = 400;
    private int width = 400;
    private JComboBox locationComboBox;
    private Auckland au;
    private JPanel panel;
    private JComboBox hotelComboBox;
    
    public SearchFrame()
    {
        String[] hotels = {"Auckland", "ChristChurch"};
        
        this.setTitle("Searching");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        this.setLayout(null);
        
        locationComboBox = new JComboBox(hotels);
        locationComboBox.setBounds(100, 0, 200, 50);
        this.add(locationComboBox);
        
        panel = new JPanel();
        panel.setBounds(100, 100, 300, 100);
        panel.setLayout(new GridLayout());
        
        au = new Auckland();
        au.displayHotels(panel);
        
        this.add(panel);
        
        
        hotelComboBox = new JComboBox<>();
        hotelComboBox.setBounds(100, 250, 200, 50);
        this.add(hotelComboBox);
        
        // Populate hotel names into the combo box
        for (Hotel hotel : au.getAucklandHotels()) {
            hotelComboBox.addItem(hotel.getName());
        }
    }
}
