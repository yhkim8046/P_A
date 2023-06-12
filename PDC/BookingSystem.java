/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private Guest guest;
    
    private JPanel mainPanel;
    private JPanel lastNamePanel;
    private JPanel firstNamePanel;
    private JPanel emailPanel;
    private JPanel mobilePanel;
    
    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JTextField emailTextField;
    private JTextField mobileTextField;
    
    
    
    
     public BookingSystem(Hotel selectedHotel)
    {
        this.selectedHotel = selectedHotel;
        this.setTitle("Check booking");
        this.dispose();
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menu item
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new CheckFrame.exit()); 
        
        confirm = JOptionPane.showConfirmDialog(null, "Please confirm the hotel again. Hotel: " + selectedHotel.getName(), "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.NO_OPTION) {
            this.dispose(); //exit the window to select again       
        } 
        
        JLabel notice = new JLabel("Please fill the information");
        
        notice.setBounds( 125, -30, 200, 100);
        notice.setVisible(true);
        this.add(notice);
        
        guest = new Guest();
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        

        lastNameTextField = new JTextField(20);
        lastNamePanel = createQuestions("Last Name:", lastNameTextField);
        mainPanel.add(lastNamePanel);

        firstNameTextField = new JTextField(20);
        firstNamePanel = createQuestions("First Name:", firstNameTextField);
        mainPanel.add(firstNamePanel);
        
        emailTextField = new JTextField(20);
        emailPanel = createQuestions("E-mail Address:", emailTextField);
        mainPanel.add(emailPanel);
        
        mobileTextField = new JTextField(20);
        mobilePanel = createQuestions("Mobile :", mobileTextField);
        mainPanel.add(mobilePanel);
        
        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
        
        private JPanel createQuestions(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        return panel;
    }
}
        