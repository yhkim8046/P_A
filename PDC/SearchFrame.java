/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

import static PDC.AppFrame.height;
import static PDC.AppFrame.width;
import javax.swing.JFrame;

/**
 *
 * @author yuhwankim
 */
public class SearchFrame extends JFrame
{
    private int height = 720;
    private int width = 720;
    
    public SearchFrame()
    {
        this.setTitle("Searching");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(width,height);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
    }
}
