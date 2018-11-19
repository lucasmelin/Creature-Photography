import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) {
        printHeader();
        gameLoop();
    }

    private static void printHeader() {
        System.out.println("-------------------");
        System.out.println(" PHOTOGRAPHY GAME");
        System.out.println("-------------------\n");
    }


    private static void gameLoop() {
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Creature("Sloth", 1));
        creatures.add(new Creature("Tree frog", 6));
        creatures.add(new Creature("Chimpanzee", 20));
        creatures.add(new Creature("Zebra", 45));
        creatures.add(new Creature("Cheetah", 100));

        for (Creature c : creatures) {
            System.out.println(c);
        }

        Human photographer = new Human("Lucas", 80);


        Scanner input = new Scanner(System.in);
        boolean running = true;
        Random random = new Random();
        while (running) {
            Creature activeCreature = creatures.get(random.nextInt(creatures.size()));
            System.out.println("A " + activeCreature.name + " with a speed of " + activeCreature.speed
                    + " has emerged from the jungle...");


            System.out.println("Do you [p]hotograph, [r]un away, or [l]ook around?");
            String action = input.next();

            switch (action) {
                case "p":
                    if (photographer.photograph(activeCreature)) {
                        creatures.remove(activeCreature);
                    } else {
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
                    System.out.println("Run away");
                    break;
                case "l":
                    System.out.println("The photographer " + photographer.name + " scans the area and spots:");
                    for (Creature c : creatures) {
                        System.out.println(" * A " + c.name + " with a speed of " + c.speed);
                    }
                    break;
                default:
                    System.out.println("Exiting game");
                    running = false;
                    break;

            }

        }
    }

}
