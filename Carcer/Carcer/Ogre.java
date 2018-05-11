
/**
 * Ogre Class defines ogre stats
 *
 * @author (Daniel Tena)
 * @version (Something)
 */
public class Ogre extends Monsters
{
    private String name;
    private double health;
    private double attack;
    private double endurance;
    private double speed;
    private double magic;
    
    /**
     * Constructor for objects of class Werewolf
     */
    public Ogre(int playerLVL)
    {
        // initialise instance variables
        name = "Ogre";
        health = 4 * (1 + (playerLVL * 0.1));
        attack = 4 * (1 + (playerLVL * 0.1));
        endurance = 4 * (1 + (playerLVL * 0.1));
        speed = 1 * (1 + (playerLVL * 0.1));
        magic = 2 * (1 + (playerLVL * 0.1));
    }// Ends the Ogre Constructor
    
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
}// Ends the Ogre Class
