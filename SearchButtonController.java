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
public class SearchButtonController implements ActionListener 
{
    private SearchFrame sf;
    
    public SearchButtonController(){
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sf = new SearchFrame();
        sf.setVisible(true);   
    }
}