/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;



/**
 *
 * @author yuhwankim
 */
public class Hotel 
{
    private String name;
    private String location;
    private int stars;
    private int costs;
    
    public Hotel(String name, String location, int stars, int costs)
    {
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.costs = costs; 
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the stars
     */
    public int getStars() {
        return stars;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * @return the costs
     */
    public int getCosts() {
        return costs;
    }

    /**
     * @param costs the costs to set
     */
    public void setCosts(int costs) {
        this.costs = costs;
    }
    
    public String toString()
    {
        return this.getName() + ", " + this.getLocation() + ": " + this.getStars() +"stars $ " + this.getCosts();
    }
}
