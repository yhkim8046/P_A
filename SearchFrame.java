/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author yuhwankim
 */
public class SearchFrame extends JFrame {

    private int height = 450;
    private int width = 450;
    private JComboBox locationComboBox;
    private Auckland au;
    private JPanel AucklandPanel;
    private JPanel ChPanel;
    private JComboBox hotelComboBox;
    private ChristChurch ch;
    
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    private JButton bookingButton;
    private Hotel selectedHotel;
   

    public SearchFrame() {
        String[] cities = {"Auckland", "Christchurch"};

        this.setTitle("Searching");
        this.dispose();

        this.setSize(width, height);
        this.setResizable(false);
        setLocationRelativeTo(null);

        this.setLayout(null);

        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit");
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new exit());

        locationComboBox = new JComboBox<>(cities);
        locationComboBox.setBounds(100, 0, 200, 50);
        this.add(locationComboBox);

        AucklandPanel = new JPanel();  //Hotel lists in Auckland
        AucklandPanel.setBounds(100, 100, 300, 100);
        AucklandPanel.setLayout(new GridLayout());
        
        bookingButton = new JButton("Booking");
        this.add(bookingButton);
        bookingButton.setBounds(300,250,100,50); 
        bookingButton.setVisible(true);
        bookingButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        Hotel selectedHotel = getSelectedHotel(); // Get the selected hotel from SearchFrame
        if (selectedHotel != null) {
            BookingSystem bookingSystem = new BookingSystem(selectedHotel); // Pass the selected hotel to BookingSystem
        } else {
            JOptionPane.showMessageDialog(SearchFrame.this, "Please select a hotel.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        });
        
        au = new Auckland();
        au.displayHotels(AucklandPanel);

        this.add(AucklandPanel);

        hotelComboBox = new JComboBox<>();
        hotelComboBox.setBounds(100, 250, 200, 50);
        this.add(hotelComboBox);
        selectedHotel = (Hotel) hotelComboBox.getSelectedItem();

        ChPanel = new JPanel(); //Hotel lists in ChristChurch
        ChPanel.setBounds(100, 100, 350, 100);
        ChPanel.setLayout(new GridLayout());

        ch = new ChristChurch();
        ch.displayHotels(ChPanel);

        this.add(ChPanel);

        // ActionListener for locationComboBox
        locationComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCity = (String) locationComboBox.getSelectedItem(); 
                if (selectedCity.equals("Auckland")) { //If Auckland selected
                    AucklandPanel.setVisible(true);
                    ChPanel.setVisible(false);
                    populateComboBox(au.getAucklandHotels());
                } else if (selectedCity.equals("Christchurch")) { //If ChristChurch selected 
                    AucklandPanel.setVisible(false);
                    ChPanel.setVisible(true);
                    populateComboBox(ch.getChHotels());
                }
            }
        });
        
    }

    private void populateComboBox(ArrayList<Hotel> hotels) { //Displaying hotels 
        hotelComboBox.removeAllItems();
        for (Hotel hotel : hotels) {
            hotelComboBox.addItem(hotel.getName());
        }
    }
     private static class exit implements ActionListener //exit menu function 
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
     
     public Hotel getSelectedHotel() {
        String selectedHotelName = (String) hotelComboBox.getSelectedItem();
        if (selectedHotelName != null) {
            // Retrieve the selected hotel from the appropriate list
            ArrayList<Hotel> hotels;
            String selectedCity = (String) locationComboBox.getSelectedItem();
            if (selectedCity.equals("Auckland")) {
                hotels = au.getAucklandHotels();
            } else {
                hotels = ch.getChHotels();
            }

            // Find the hotel with the selected name
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(selectedHotelName)) {
                    return hotel; // Return the selected hotel object
                }
            }
        }
        return null; // Return null if no hotel is selected or found
    }
}
