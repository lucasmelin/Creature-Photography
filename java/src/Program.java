import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This file contains the photography game logic that drives the application.
 *
 * Date created: Nov 15, 2018
 * Date last modified: Mar 09, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
public class Program {

    /**
     * Entry-point to the program. Calls the header to print, then enters the game loop.
     * @param args
     */
    public static void main(String[] args) {
        printHeader();
        gameLoop();
    }

    /**
     * Prints the game header to the console.
     * Ascii camera adapted from hjw. https://asciiart.website/index.php?art=objects/cameras
     */
    private static void printHeader() {
        System.out.println("--------------------------");
        System.out.println("      LUCAS MELIN'S");
        System.out.println(" JUNGLE PHOTOGRAPHY GAME");
        System.out.println("--------------------------\n");
        System.out.println("        .---.");
        System.out.println("        |[0]|");
        System.out.println(" _.==._.\"\"\"\"\".___n__");
        System.out.println("d __ ___.-''-. _____b");
        System.out.println("|[__]  /.\"\"\"\".\\ _   |");
        System.out.println("|     // /\"\"\\ \\\\_)  |");
        System.out.println("|     \\\\ \\__/ //    |");
        System.out.println("|      \\`.__.'/     |");
        System.out.println("\\=======`-..-'======/");
        System.out.println(" `-----------------' ");
        System.out.println("--------------------------\n");
    }


    /**
     * Receives input from the command line to determine which action to take. Once all the
     * creatures have been successfully photographed, exits the game loop.
     */
    private static void gameLoop() {
        // This list takes the super class Creature, but can also contain any objects that
        // subclass from creature
        List<Creature> creatures = new ArrayList<>();
        // Base class object
        creatures.add(new Creature("Sloth", 1));
        // Sub class object
        creatures.add(new SmallAnimal("Tree frog", 6));
        creatures.add(new Creature("Chimpanzee", 20));
        creatures.add(new CamouflagedAnimal("Zebra", 45, 2, false));
        creatures.add(new CamouflagedAnimal("Cheetah", 80, 6, false));
        creatures.add(new CamouflagedAnimal("Chameleon", 2, 10, true));

        // Humans also inherit from the base class Creature
        Human photographer = new Human("Lucas", 80);

        // Setup variables needed for running the game loop, such as the scanner to read from the command line
        Scanner input = new Scanner(System.in);
        boolean running = true;
        Random random = new Random();
        while (running) {
            // Randomly choose the active creature from the creatures left in the list
            Creature activeCreature = creatures.get(random.nextInt(creatures.size()));
            // Print the creature's information using inherited fields name and speed
            System.out.println("A " + activeCreature.name + " with a speed of " + activeCreature.speed
                    + " has emerged from the jungle...");

            // Prompt the user to select an action to take
            System.out.println("Do you [p]hotograph, [r]eposition, or [l]ook around?");
            String action = input.next();

            switch (action) {
                case "p":
                    if (photographer.photograph(activeCreature)) {
                        // Taking a picture succeeded, remove that creature from the list
                        creatures.remove(activeCreature);
                    } else {
                        // Taking a picture failed, sleep for 5 seconds before prompting the user again
                        System.out.println("You've been spotted! You get up and move to a different position.");
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("You settle in with your camera at the ready.");
                    }
                    break;
                case "r":
                    // Print a repositioning message and loop again
                    System.out.println("You're not sure you can get a clear picture, so you get up and reposition yourself.");
                    break;
                case "l":
                    // Print everything still present in the creatures list
                    System.out.println("The photographer " + photographer.name + " scans the area and spots:");
                    for (Creature c : creatures) {
                        System.out.println(" * A " + c.name + " with a speed of " + c.speed);
                    }
                    break;
                default:
                    // If something else is entered, assume the user wants to quit
                    System.out.println("Exiting game");
                    running = false;
                    break;
            }
            if (creatures.isEmpty()){
                // All creatures have been photographed and removed from the List. The game has been won.
                System.out.println("You've photographed all the creatures! Congratulations!");
                running = false;
            }
        }
    }
}
