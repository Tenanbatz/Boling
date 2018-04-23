import java.io.*;
import java.util.*;
/**
 * Write a description of class Characters here.
 * 
 * @author (Daniel Tena) 
 * @version (4/18/18)
 */
public class Characters
{
    private Scanner user;
    public Characters()
    {
        user = new Scanner(System.in);
    }
    
    public void Characters()
    {
        int classChoice = 0;
        String name = "";
        
        System.out.println("Enter character name: ");
        name = user.nextLine();
        
        while(true)
        {
            System.out.println("Choose your class");
            System.out.println("1. Berserker\n2. Caster\n3. Assassin\n4. Archer\n5. Knight");
            System.out.println("Choice: ");
            classChoice = user.nextInt();
            String character;

            if(classChoice == 1)
            {
                break;
            }
            else if(classChoice == 2)
            {
                break;
            }
            else if(classChoice == 3)
            {
                break;
            }
            else if(classChoice == 4)
            {
                break;
            }
            else if(classChoice == 5)
            {
                break;
            }
            else
            {
                System.out.println("\f");
            }
        }
    }
    
}
