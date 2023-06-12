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
    private int confirmHotelName; // used for confirmation of the name of hotel being booked
    private SearchFrame sf;
    
    public BookingSystem()
    {
        this.setTitle("Check booking");
        this.dispose();
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menuitem
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new CheckFrame.exit());
        
        sf = new SearchFrame();
        
        confirmHotelName = JOptionPane.showConfirmDialog(null, "Please confirm the hotel again:  " + sf.getSelectedHotel(), "Confirmation", JOptionPane.YES_NO_OPTION);
        if(confirmHotelName == JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
        else
        {
            this.dispose();
        }
    }
    
}
