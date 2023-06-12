/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author yuhwankim
 */
public class BookingSystem extends JFrame{
    
    private int height = 400;
    private int width = 400;
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    private int confirm; //confirm the hotel which is being booked
    private Hotel selectedHotel;
    
    
    public BookingSystem(Hotel selectedHotel)
    {
        this.selectedHotel = selectedHotel;
        this.setTitle("Check booking");
        this.dispose();
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menu item
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new CheckFrame.exit()); 
        
        confirm = JOptionPane.showConfirmDialog(null, "Please confirm the hotel again. Hotel: " + selectedHotel.getName(), "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked "Yes"
          
        } else {
            // User clicked "No" or closed the dialog
            this.dispose(); //exit the window to select again 
        }
        
    }
}
