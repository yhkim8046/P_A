/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDC;

/**
 *
 * @author yuhwankim
 */
public class Rooms 
{
    private String type; 
    private int costs; 
    
    public Rooms(String type, int costs)
    {
        this.type = type;
        this.costs = costs;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
        return this.getType() +" : $" + this.getCosts();
    }
}
