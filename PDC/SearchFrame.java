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
    private JPanel AucklandPanel;
    private JPanel ChPanel;
    private JComboBox hotelComboBox;
    private ChristChurch ch;
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem newMenuItem;

    
    
        public SearchFrame() {
        String[] cities = {"Auckland", "Christchurch"};

        this.setTitle("Searching");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(width, height);
        this.setResizable(false);
        setLocationRelativeTo(null);

        this.setLayout(null);
        
        menuBar = new JMenuBar();
        homeMenu = new JMenu("Home");
        menuBar.add(homeMenu);
        this.setJMenuBar(menuBar);

        locationComboBox = new JComboBox<>(cities);
        locationComboBox.setBounds(100, 0, 200, 50);
        this.add(locationComboBox);

        AucklandPanel = new JPanel();
        AucklandPanel.setBounds(100, 100, 300, 100);
        AucklandPanel.setLayout(new GridLayout());

        au = new Auckland();
        au.displayHotels(AucklandPanel);

        this.add(AucklandPanel);

        hotelComboBox = new JComboBox<>();
        hotelComboBox.setBounds(100, 250, 200, 50);
        this.add(hotelComboBox);

        ChPanel = new JPanel();
        ChPanel.setBounds(50, 100, 350, 100);
        ChPanel.setLayout(new GridLayout());

        ch = new ChristChurch();
        ch.displayHotels(ChPanel);

        this.add(ChPanel);

        // ActionListener for locationComboBox
        locationComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCity = (String) locationComboBox.getSelectedItem();
                if (selectedCity.equals("Auckland")) {
                    AucklandPanel.setVisible(true);
                    ChPanel.setVisible(false);
                    populateComboBox(au.getAucklandHotels());
                } else if (selectedCity.equals("Christchurch")) {
                    AucklandPanel.setVisible(false);
                    ChPanel.setVisible(true);
                    populateComboBox(ch.getChHotels());
                }
            }
        });
    }

    private void populateComboBox(ArrayList<Hotel> hotels) {
        hotelComboBox.removeAllItems();
        for (Hotel hotel : hotels) {
            hotelComboBox.addItem(hotel.getName());
        }
    }
    
}
