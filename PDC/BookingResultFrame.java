/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import static PDC.AppFrame.height;
import static PDC.AppFrame.width;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
    
    public BookingResultFrame(){
        this.setTitle("Booking Result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(width, height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        
        menuBar = new JMenuBar();
        exitMenu = new JMenuItem("Exit"); //program exit menu item
        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);

        exitMenu.addActionListener(new CheckFrame.exit());
    }
}
