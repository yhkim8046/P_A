/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class CheckFrame extends JFrame{
    private int height = 400;
    private int width = 400;
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    private JPanel panel;
    private JTextField t;
    private JPanel userPanel;
   
    public CheckFrame()
    {
        this.setTitle("Check booking");
        this.dispose();
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        this.setLayout(null);
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menuitem
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
      
        exitMenu.addActionListener(new CheckFrame.exit());
        
        panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Please enter your first name: ");
        label.setBounds(0, 0, 200, 20);
        panel.add(label);
        panel.setBounds(80, 80, 300, 100);

        this.add(panel);

        userPanel = new JPanel();
        userPanel.setLayout(null);
        t = new JTextField(); //
        
        t.setBounds(0, 0, 200, 20);
        userPanel.add(t);
        userPanel.setBounds(80, 120, 300, 100);
        this.add(userPanel);
        
        
        JButton c = new JButton("Find booking");
        c.setBounds(150,150,100,50);
        this.add(c);
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = t.getText();
                BookingHistory bookingHistory = new BookingHistory();//
                bookingHistory.displayBookingHistory(userName);
                bookingHistory.setVisible(true);
            }
        });
        
        
        this.setVisible(true);
    }

    void displayBookingHistory(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static class exit implements ActionListener //program exit function
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
}
