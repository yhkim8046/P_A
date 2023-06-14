/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author yuhwankim
 */
public class Guest 
{
    private Hotel hotel;
    
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long nights;
    private int totalPrice;
    private String selectedHotelName;
    
    public Guest()
    {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.mobile = "";
        this.checkInDate = null; 
        this.checkOutDate = null;
        this.nights = 0;
        this.selectedHotelName = ""; 
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String toStrng()
    {
        return this.getFirstName() + " " + this.getLastName() + " Email: " + this.getEmail() + " Mobile: " + this.getMobile();
    }

   
   
    
    public String getFormattedBookingDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedCheckInDate = getCheckInDate().format(formatter);
        String formattedCheckOutDate = getCheckOutDate().format(formatter);
        return formattedCheckInDate + " - " + formattedCheckOutDate;
    }


    /**
     * @return the checkInDate
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

   
   public void setCheckInDate(String checkInDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkInDate = LocalDate.parse(checkInDateStr, formatter);
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkOutDate
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
   public void setCheckOutDate(String checkOutDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkOutDate = LocalDate.parse(checkOutDateStr, formatter);
        this.checkOutDate = checkOutDate;
    }


    public long getNights() {
        return checkInDate.until(checkOutDate, ChronoUnit.DAYS);
    }

    public void setTotalPrice(int costs, long nights)
    {
        this.totalPrice = costs * (int)nights; 
    }
    
    public int getTotalPrice()
    {
        return this.totalPrice;
    }
    
    public void setSelectedHotelName(String name)
    {
        this.selectedHotelName = name;
    }
    public String getSelectedHotelName()
    {
        return this.selectedHotelName;
    }
}
    