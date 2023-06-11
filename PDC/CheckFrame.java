/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import javax.swing.JFrame;

/**
 *
 * @author yuhwankim
 */
public class CheckFrame extends JFrame{
    private int height = 720;
    private int width = 720;
    
    public CheckFrame()
    {
        this.setTitle("Check booking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
    }
}
