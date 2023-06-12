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
public class BookingButtonController implements ActionListener {
    private BookingSystem b;
    
    public BookingButtonController(){
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        b = new BookingSystem();
        b.setVisible(true);
    }
}
