import java.io.*;
import java.util.*;
/**
 * Controls story and runs combat
 * 
 * @author (Cameron Tabion) 
 * @version (Something)
 */
public class User
{
    private String name;
    private ArrayList<Integer> stats;
    private Scanner file;
    private FileWriter out;
    private wait w;
    private Combat combat;

    /**
     * User Constructor
     *
     * @param charName - name of character
     */
    public User(String charName)
    {
        name = charName.substring(0, 1).toUpperCase() + charName.substring(1);
        w = new wait();
    }// Ends the User Constructor

    /**
     * Method getStats gets stats from character file
     */
    public void getStats()
    {
        try
        {
            stats = new ArrayList<Integer>();
            file = new Scanner(new File("saves/" + name.toLowerCase() + ".txt"));
            // Get Stats
            while (file.hasNextInt())
            {
                stats.add(file.nextInt());
            }// Ends the while
        }// Ends the try
        catch (FileNotFoundException e)
        {
            System.out.println("\f" + e.getMessage());
        }// Ends the catch
    }// Ends the getStats Method

    /**
     * Method intro displays the introduction text
     */
    public void intro() throws InterruptedException
    {
        System.out.println("\fWelcome to the endless dungeon Carcer.");
        w.w(1000);
        System.out.println("In this dungeon you will encounter different enemies within each room.");
        w.w(1500);
        System.out.println("Each floor will have a random amount of rooms, no floor is the same.");
        w.w(1500);
        System.out.println("You will fight enemies in turn based combat. You heal inbetween combat.");
        w.w(1500);
        System.out.println("Each class and monster has a different set of skills and stats.");
        w.w(1000);
        System.out.println("Your goal is to reach the bottom of the dungeon, but the thing is there is no bottom.");
        w.w(2000);
        System.out.println("Good Luck " + name + "!");
        w.w(2000);
    }// Ends the intro Method

    /**
     * Method start starts the actual game
     */
    public void start() throws InterruptedException
    {
        combat = new Combat(name);
        while (true)
        {
            getStats();
            System.out.println("\fFloor: " + stats.get(5) + " - Room: " + stats.get(10) + " out of " + stats.get(9));
            combat.start();
        }// Ends the while
    }// Ends the start Method
}// Ends the User Class
