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
    //Variablen gehen hier
    private Scanner user;
    private stats stats;
    
    public Characters()
    {
        //Initialisierung
        user = new Scanner(System.in);
        stats = new stats();
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
            
            //Abhängig von der gewählten Klasse wird eine andere Methode aufgerufen.
            //NOTE THAT I STILL HAVE TO DO ALL CLASS METHODS OTHER THAN KNIGHT CAUSE LAZY
            if(classChoice == 1)
            {
                stats.getBerserker();
            }
            else if(classChoice == 2)
            {
                stats.getCaster();
            }
            else if(classChoice == 3)
            {
                stats.getAssassin();
            }
            else if(classChoice == 4)
            {
                stats.getArcher();
            }
            else if(classChoice == 5)
            {
                stats.getKnight();
            }
            else
            {
                System.out.println("\f");
            }
        }
    }
    
}//Ende des Programms

