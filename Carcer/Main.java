import java.io.*;
import java.util.*;
/**
 * Runs all the classes through here
 * 
 * @author (Daniel Tena....) 
 * @version (4/18/18)
 */
public class Main
{
    private Scanner user;
    private Characters Characters;
    private int menu;

    Main()
    { 
        user = new Scanner(System.in);
        Characters = new Characters();
        menu = 0;
    }

    public int getMenu()
    {
        menu();
        return menu;
    }

    private void menu()
    {
        while(true)
        {
            System.out.println("1. Continue Character");
            System.out.println("2. Create New Character");
            System.out.print("Choice: ");
            menu = user.nextInt();

            if(menu == 1)
            {
                System.out.println("\f");
                break;
            }
            else if(menu == 2)
            {
                Characters.Characters();
                System.out.println("\f");
                break;
            }
            else
            {
                System.out.println("\f");
            }
        }
    }

}
