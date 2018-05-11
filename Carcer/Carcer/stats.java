import java.io.*;
import java.util.*;
/**
 * Gets class stats and creates a character file
 * 
 * @author (Cameron Tabion) 
 * @version (4/19/18)
 */
public class stats
{
    // Variablen gehen hier
    private String fileName;
    private String line;
    private ArrayList<Integer> info;
    private Scanner file;
    private int cnt;
    private Random rand;
    private FileWriter out;
    private wait w;

    /**
     * stats Constructor
     */
    public stats()
    {
        fileName = "";
        line = null;
        cnt = 0;
        rand = new Random();
        info = new ArrayList<Integer> ();
        w = new wait();
    }// Ends the stats Constructor

    /**
     * Method getStats gets class stats and saves it to a character file
     *
     * @param name - character name
     * @param className - name of class
     */
    public void getStats(String name, String className) throws InterruptedException
    {
        fileName = className + ".txt";
        try
        {
            file = new Scanner(new File("basestats/" + fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("saves/" + name.toLowerCase() + ".txt"));
            // Get Base Stats (Health 0, Attack 1, Endurance 2, Speed 3, Magic 4)
            while (file.hasNextInt())
            {
                info.add(file.nextInt());
                writer.write(info.get(cnt).toString() + "\r\n");
                cnt++;
            }// Ends the while
            // Floor Level - 5
            writer.write("1" + "\r\n");
            // Character Level - 6
            writer.write("1" + "\r\n");
            // EXP - 7
            writer.write("0" + "\r\n");
            // EXP to Next Level up - 8
            writer.write("50" + "\r\n");
            // Total Room Number - 9
            writer.write(rand.nextInt(9)+2 + "\r\n");
            // Current Room Number - 10
            writer.write("1" + "\r\n");
            writer.close();
            // Print Stats
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            System.out.println("\f" + name + "'s Base Stats: ");
            w.w(500);
            System.out.println("Health: " + info.get(0));
            w.w(500);
            System.out.println("Attack: " + info.get(1));
            w.w(500);
            System.out.println("Endurance: " + info.get(2));
            w.w(500);
            System.out.println("Speed: " + info.get(3));
            w.w(500);
            System.out.println("Magic: " + info.get(4));
            w.w(500);
            System.out.println("\nHello " + name + "! Your adventure begins now!");
            w.w(1000);
        }// Ends the try
        catch(IOException e)
        {
            System.out.println("ERROR: " + e.getMessage());
            w.w(1000);
            System.exit(0);
        }// Ends the catch
    }// Ends the getStats Method
}// Ends teh stats Class