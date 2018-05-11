import java.io.*;
import java.util.*;
/**
 * Runs all the classes through here
 * 
 * @author (Daniel Tena) 
 * @version (4/18/18)
 */
public class Main
{
    private Scanner in;
    private Characters Characters;
    private String charName;
    private User user;
    private int menu;

    /**
     * Main Constructor
     */
    Main()
    { 
        in = new Scanner(System.in);
        Characters = new Characters();
        charName = "";
        menu = 0;
    }// Ends the Main Constructor

    /**
     * Method menu displays the main menu
     */
    public void menu() throws InterruptedException
    {
        while(true)
        {
            System.out.println("\fWelcome to Carcer!");
            System.out.println("1. Continue Character");
            System.out.println("2. Create New Character");
            System.out.print("Choice: ");
            menu = in.nextInt();
            if(menu == 1)
            {
                charName = Characters.Continue();
                user = new User(charName);
                user.start();
            }// Ends the if
            else if(menu == 2)
            {
                charName = Characters.Characters();
                user = new User(charName);
                user.intro();
                user.start();
            }// Ends the else if
            else
            {
                System.out.print("\fInvalid Option");
            }// Ends the else
        }// Ends the while
    }// Ends the menu Method
}// Ends the Main Class
