
/**
 * SpaceUnicornWizard Class defines Space Unicorn Wizard stats
 *
 * @author (Kathy Vuong)
 * @version (Something)
 */
public class SpaceUnicornWizard extends Monsters implements Passive
{
    private String name;
    private double health;
    private double attack;
    private double endurance;
    private double speed;
    private double magic;
    
    public int passiveWeight;
    
    /**
     * Constructor for objects of class SpaceUnicornWizard
     */
    public SpaceUnicornWizard(int playerLVL)
    {
        // initialise instance variables
        name = "Space Unicorn Wizard";
        health = 5 * (1 + (playerLVL * 0.1));
        attack = 5 * (1 + (playerLVL * 0.1));
        endurance = 3 * (1 + (playerLVL * 0.1));
        speed = 5 * (1 + (playerLVL * 0.1));
        magic = 4 * (1 + (playerLVL * 0.1));
        
        // Apply passive
        passiveWeight = 100;
    }// Ends the SpaceUnicornWizard Constructor

    /**
     * Method passive applies passive
     */
    public void passive()
    {
        // put your code here
        magic += passiveWeight;
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
