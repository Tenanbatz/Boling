
/**
 * Kathulu Class defines Kathulu stats
 *
 * @author (Kathy Vuong)
 * @version (Something)
 */
public class Kathulu extends Monsters implements Passive
{
    private String name;
    private double health;
    private double attack;
    private double endurance;
    private double speed;
    private double magic;
    
    public int passiveWeight;
    
    /**
     * Constructor for objects of class Werewolf
     */
    public Kathulu(int playerLVL)
    {
        // initialise instance variables
        name = "Kathulu";
        health = 6 * (1 + (playerLVL * 0.1));
        attack = 6 * (1 + (playerLVL * 0.1));
        endurance = 4 * (1 + (playerLVL * 0.1));
        speed = 3 * (1 + (playerLVL * 0.1));
        magic = 6 * (1 + (playerLVL * 0.1));
        passiveWeight = 3;
    }
    
    /**
     * Method passive applies the passive
     */
    public void passive()
    {
        endurance += 3;
    }// Ends the passive Method
    
    /**
     * Method getPassiveWeight
     *
     * @return passiveWeight
     */
    public int getPassiveWeight()
    {
        return passiveWeight;
    }// Ends the getPassiceWeight Method

    /**
     * Method setPassiveWeight
     *
     * @param weight
     */
    public void setPassiveWeight(int weight)
    {
        passiveWeight = weight;
    }// Ends the setPassiveWeight Method
    
    /**
     * Method getName
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }// Ends the getName Method
    
    /**
     * Method getHealth
     *
     * @return health
     */
    public double getHealth()
    {
        return health;
    }// Ends the getHealth Method
    
    /**
     * Method attack
     *
     * @return attack
     */
    public double attack()
    {
        return attack;
    }// Ends the attack Method
    
    /**
     * Method getEndurance
     *
     * @return endurance
     */
    public double getEndurance()
    {
        return endurance;
    }// Ends the getEndurance Class
    
    /**
     * Method getSpeed
     *
     * @return speed
     */
    public double getSpeed()
    {
        return speed;
    }// Ends the getSpeed Method
    
    /**
     * Method getMagic
     *
     * @return magic
     */
    public double getMagic()
    {
        return magic;
    }// Ends the getMagic Method
}
