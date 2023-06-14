/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author yuhwankim
 */
public class CheckFrame extends JFrame{
    private int height = 400;
    private int width = 400;
    private JMenuBar menuBar;
    private JMenuItem exitMenu;
    
    public CheckFrame()
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
    }
    
    public static class exit implements ActionListener //program exit function
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
