/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

/**
 *
 * @author yuhwankim
 */
public class Guest 
{
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    
    public Guest(String firstName, String lastName, String email, String mobile)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile; 
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
    
}
