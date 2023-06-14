/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import static PDC.AppFrame.height;
import static PDC.AppFrame.width;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author yuhwankim
 */
public class BookingResultFrame extends JFrame
{
    private int height = 400;
    private int width = 400;
   
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    
    private JLabel referenceNumberLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel MobileLabel;
    private JLabel emailLabel;
    private JLabel datesLabel; 
    private JLabel nightLabel;
    
    private JPanel information;
    
    private Guest guest;
    
    public BookingResultFrame(Guest guest){
        this.guest = guest;
        
        this.setTitle("Booking Result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(width, height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        this.setLayout(new FlowLayout());
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menu item
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);

        exitMenu.addActionListener(new CheckFrame.exit());
       
        information = new JPanel();
        information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
        information.add(createLabel("Thank you for booking ", guest.getSelectedHotelName()));
        information.add(createLabel("Last Name:", guest.getLastName()));
        information.add(createLabel("First Name:", guest.getFirstName()));
        information.add(createLabel("Email Address:", guest.getEmail()));
        information.add(createLabel("Mobile:", guest.getMobile()));
        information.add(createLabel("Staying Date (dd/MM/yyyy):", guest.getFormattedBookingDate()));
        information.add(createNight(guest.getNights(), "Night(s)"));
        information.add(createCost("Total Cost: $" , guest.getTotalPrice()));
        information.add(Box.createVerticalGlue());

        // Add the main panel to the frame
        this.add(information);

        this.setVisible(true); 
    }

    private JLabel createLabel(String labelText, String value) {
        JLabel label = new JLabel(labelText + " " + value);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
        private JLabel createNight(long nigths, String s)
        {
            JLabel label = new JLabel(nigths + s);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            return label;
        }
        
    private JLabel createCost(String labelText, int costs) {
    JLabel label = new JLabel(labelText + costs);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    return label;
    }
}
