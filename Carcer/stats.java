import java.io.*;
import java.util.*;
/**
 * Write a description of class stats here.
 * 
 * @author (Daniel Tena) 
 * @version (4/19/18)
 */
public class stats
{
    // Variablen gehen hier
    String fileName = "";
    String line = null;
    ArrayList<String> info = new ArrayList<String>();
    
    public void getKnight()
    {
        fileName = "knight.txt";
        try
        {
            FileReader reder = new FileReader(fileName);
            BufferedReader buf = new BufferedReader(reder);
            while((line = buf.readLine()) != null)
            {
                //Ich weiß nicht, wie man Dinge aus Dateien in Arrays einfügt
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("ERROR 01: File Not Found");
        }
        catch(IOException ex)
        {
            System.out.println("ERROR 02: Trouble Reading File");
        }
    }
}
//stats.getKnight