/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;
        
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yuhwankim
 */
public class CheckButtonControlloer implements ActionListener 
{
    private CheckFrame cf;
   
    public CheckButtonControlloer(){
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cf = new CheckFrame();
        cf.setVisible(true);
    }
}
  
