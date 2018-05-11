import java.util.*;
import java.io.*;
/**
 * Combat Class controls the combat system
 * 
 * @author (Cameron Tabion) 
 * @version (Something)
 */
public class Combat
{
    // Instance Variables
    private Random rand;
    private Monsters mon;
    private ArrayList<Integer> stats;
    private Scanner file, in;
    private wait w;
    private String name;
    private int floorNum, roomNum, totRoomNum, cnt, charLVL, charHealth, charAttack, 
    charEndurance, charSpeed, charMagic, charEXP, charTotEXP;

    /**
     * Combat Constructor
     *
     * @param charName - name of character
     */
    public Combat(String charName)
    {
        // Other
        cnt = 0;
        rand = new Random();
        in = new Scanner(System.in);
        mon = chooseMonster();
        w = new wait();

        // Stats
        name = charName;
        getStats();
    }// Ends the Combat Constructor

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
            charHealth = stats.get(0);
            charAttack = stats.get(1);
            charEndurance = stats.get(2);
            charSpeed = stats.get(3);
            charMagic = stats.get(4);
            floorNum = stats.get(5);
            charLVL = stats.get(6);
            charEXP = stats.get(7);
            charTotEXP = stats.get(8);
            totRoomNum = stats.get(9);
            roomNum = stats.get(10);
        }// Ends the try
        catch (FileNotFoundException e)
        {
            System.out.println("\f" + e.getMessage());
            w.w(1000);
            System.exit(0);
        }// Ends the catch
    }// Ends the getStats Method

    /**
     * Method start outlines combat flow
     */
    public void start() throws InterruptedException
    {
        // Reset Stats
        getStats();
        // Choose Monster
        chooseMonster();
        // Initiate Combat
        startBattle();
        // End Combat
        endBattle();
    }// Ends the start Method

    /**
     * Method chooseMonster randomly determines monster
     *
     * @return mon - the type of monster
     */
    public Monsters chooseMonster()
    {
        int val = rand.nextInt(9);
        if (val < 3) mon = new Werewolf(charLVL);
        else if (val >= 3 && val < 6) mon = new Ogre(charLVL);
        else if (val >= 6 && val < 8) mon = new SpaceUnicornWizard(charLVL);
        else if (val == 8) mon = new Kathulu(charLVL);
        return mon;
    }// Ends the chooseMonster Method

    /**
     * Method startBattle starts the main battle process
     */
    public void startBattle() throws InterruptedException
    {
        double monHealth = mon.getHealth();
        int turn = 1;
        boolean monTurn = false;
        while (monHealth > 0 && charHealth > 0)
        {
            int choice;
            w.w(500);
            System.out.println("\n------------------Turn: " + turn + "------------------");
            w.w(500);
            System.out.println(mon.getName() + ":");
            w.w(500);
            System.out.println("Hp: " + monHealth);
            System.out.println("Attack: " + mon.attack());
            System.out.println("Endurance: " + mon.getEndurance());
            System.out.println("Speed: " + mon.getSpeed());
            System.out.println("Magic: " + mon.getMagic());
            w.w(500);
            System.out.println("\n" + name + ": ");
            System.out.println("Hp: " + charHealth);
            System.out.println("Attack: " + charAttack);
            System.out.println("Endurance: " + charEndurance);
            System.out.println("Speed: " + charSpeed);
            System.out.println("Magic: " + charMagic);
            w.w(500);
            if (mon.getSpeed() > charSpeed && turn == 1)
            {
                System.out.println("\n" + mon.getName() + " is faster than you! They go first: ");
                System.out.println("The " + mon.getName() + " attacks you, dealing " + mon.attack() + " damage!");
                charHealth -= mon.attack()-(charEndurance/2);
                turn += 1;
                monTurn = false;
                w.w(1000);
            }// Ends the if
            else if (!monTurn)
            {
                System.out.println("\nWhat will you do?\n1. Attack\n2. Run");
                System.out.print("Choice: ");
                choice = in.nextInt();
                while (choice != 1 && choice != 2)
                {
                    System.out.print("Invalid Choice: ");
                    choice = in.nextInt();
                }// Ends the while
                switch (choice)
                {
                    case 1:
                    double damage = charAttack-(mon.getEndurance()/2);
                    System.out.println("\nYou attack and deal " + damage + " Damage!");
                    monHealth -= damage;
                    turn += 1;
                    monTurn = true;
                    w.w(1000);
                    break;
                    case 2:
                    System.out.println("\fYou cannot escape Carcer! The " + mon.getName() + " chases you down and kills you!");
                    w.w(1500);
                    save();
                    System.exit(0);
                    break;
                }// Ends the switch
            }// Ends the else if
            else
            {
                System.out.println("\n" + mon.getName() + "'s turn!");
                System.out.println("He attacks and deals " + mon.attack() + " damage!");
                charHealth -= mon.attack()-(charEndurance/2);
                turn += 1;
                monTurn = false;
                w.w(1000);
            }// Ends the else
        }// Ends the while
        if (monHealth <= 0)
        {
            System.out.println("\nYou killed the " + mon.getName() + "!");
            w.w(1500);
        }// Ends the else
        else if (charHealth <= 0)
        {
            System.out.println("\nYou died to the " + mon.getName() + "!");
            w.w(1500);
            save();
            System.exit(0);
        }// Ends the else if
    }// Ends the startBattle Method

    /**
     * Method endBattle ends the battle and controls other conditions
     */
    public void endBattle()
    {
        System.out.println("\fRoom Completed!");
        w.w(500);

        // Move to Next room
        roomNum += 1;
        charEXP += 25;

        // Check for Lvl up - Add to stats
        if (charEXP >= charTotEXP)
        {
            charEXP -= charTotEXP;
            charTotEXP += 10;
            charLVL += 1;
            charHealth = stats.get(0);
            System.out.println("\nYou Leveled Up!");
            System.out.print("Health: " + charHealth);
            charHealth += rand.nextInt(3)+1;
            System.out.print(" -> " + charHealth + "\n");
            System.out.print("Attack: " + charAttack);
            charAttack += rand.nextInt(3)+1;
            System.out.print(" -> " + charAttack + "\n");
            System.out.print("Endurance: " + charEndurance);
            charEndurance += rand.nextInt(3)+1;
            System.out.print(" -> " + charEndurance + "\n");
            System.out.print("Speed: " + charSpeed);
            charSpeed += rand.nextInt(3)+1;
            System.out.print("-> " + charSpeed + "\n");
            System.out.print("Magic: " + charMagic);
            charMagic += rand.nextInt(3)+1;
            System.out.print(" -> " + charMagic + "\n");
            w.w(1500);
        }// Ends the if

        // Check for floor completion - reward
        if (roomNum == totRoomNum)
        {
            roomNum = 1;
            floorNum += 1;
            totRoomNum = rand.nextInt(9)+2;
            System.out.println("\nCongratulations " + name + "! You completed the floor, here's a reward!");
            w.w(500);
            int pickSkill = rand.nextInt(5);
            switch (pickSkill)
            {
                case 0:
                System.out.print("Health Up!\nTotal Health: " + charHealth);
                charHealth += rand.nextInt(2)+3;
                System.out.print(" -> " + charHealth);
                break;
                case 1:
                System.out.print("Attack Up!\nBase Attack: " + charAttack);
                charAttack += rand.nextInt(2)+3;
                System.out.print(" -> " + charAttack);
                break;
                case 2:
                System.out.print("Endurance Up!\nEndurance: " + charEndurance);
                charEndurance += rand.nextInt(2)+3;
                System.out.print(" -> " + charEndurance);
                break;
                case 3:
                System.out.print("Speed Up!\nSpeed: " + charSpeed);
                charSpeed += rand.nextInt(2)+3;
                System.out.print(" -> " + charSpeed);
                break;
                case 4:
                System.out.print("Magic Up!\nMagic: " + charMagic);
                charMagic += rand.nextInt(2)+3;
                System.out.print(" -> " + charMagic);
                break;
            }// Ends the switch
            w.w(1500);
        }// Ends the if

        // Save Stats
        save();
    }// Ends the endBattle Method

    /**
     * Method save saves the current data to the character file
     */
    public void save()
    {
        // Save data to file
        System.out.println("\nSaving Data...");
        w.w(2000);
        charHealth = stats.get(0);
        try
        {
            file = new Scanner(new File("saves/" + name.toLowerCase() + ".txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("saves/" + name.toLowerCase() + ".txt"));
            // Save Base Stats (Health, Attack, Endurance, Speed, Magic)
            writer.write(charHealth + "\r\n");
            writer.write(charAttack + "\r\n");
            writer.write(charEndurance + "\r\n");
            writer.write(charSpeed + "\r\n");
            writer.write(charMagic + "\r\n");
            // Floor Level - 5
            writer.write(floorNum + "\r\n");
            // Character Level - 6
            writer.write(charLVL + "\r\n");
            // EXP - 7
            writer.write(charEXP + "\r\n");
            // EXP to Next Level up - 8
            writer.write(charTotEXP + "\r\n");
            // Total Room Number - 9
            writer.write(totRoomNum + "\r\n");
            // Current Room Number - 10
            writer.write(roomNum + "\r\n");
            writer.close();
        }// Ends the try
        catch(IOException e)
        {
            System.out.println("ERROR: " + e.getMessage());
            w.w(1000);
            System.exit(0);
        }// Ends the catch
    }// Ends the save Method
}// Ends the Combat Class
