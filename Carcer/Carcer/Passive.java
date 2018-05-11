
/**
 * Certain monsters have passives
 *
 * @author (Kathy Vuong)
 * @version (4/26/18)
 */
public interface Passive
{
    public int passiveWeight = 0;
    
    /**
     * Method passive applies passive
     */
    public void passive(); // Ends the passive Method
    
    /**
     * Method getPassiveWeight
     *
     * @return passiveWeight
     */
    public int getPassiveWeight(); // Ends the getPassiveWeight Method
    
    /**
     * Method setPassiveWeight
     *
     * @param weight
     */
    public void setPassiveWeight(int weight); // Ends the setPassiveWeight Method
}// Ends the Passive Interface
