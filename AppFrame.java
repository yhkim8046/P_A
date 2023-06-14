/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author yuhwankim
 */
public class AppFrame extends JFrame
{
    public static final int height = 400;
    public static final int width = 400;
    private JButton searchButton;
    private JButton checkButton;
    
    public AppFrame()
    {
        this.setTitle("Bookings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
      
        searchButton = new JButton("Search Hotels");
        searchButton.setBounds(150, 100, 100, 50);
        this.add(searchButton);
        
        SearchButtonController searchController = new SearchButtonController();
        searchButton.addActionListener(searchController);
        
        checkButton = new JButton("Check booking");
        checkButton.setBounds(150, 200, 100, 50);
        this.add(checkButton);
        
        CheckButtonControlloer checkButtonControlloer = new CheckButtonControlloer();
        checkButton.addActionListener(checkButtonControlloer);
        
        this.revalidate(); // Update the frame's layout
        this.repaint();    // Repaint the frame to display the buttons
    }
}
