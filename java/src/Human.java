import java.util.Random;

public class Human {
    public String name;
    public int speed;

    public Human(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public boolean photograph(Creature creature) {
        Random random = new Random();
        System.out.println(this.name + " attempts to photograph " + creature.name);

        // Generate an integer in the range 1 - 20
        int shutterSpeed = (random.nextInt(19) + 1) * this.speed;
        int evasionSpeed = (random.nextInt(19) + 1) * creature.speed;

        System.out.println("You snap picture with a speed of " + shutterSpeed);
        System.out.println(creature.name + " runs away with a speed of " + evasionSpeed);

        if (shutterSpeed >= evasionSpeed) {
            System.out.println("You check your camera, and you have a clear picture of the " + creature.name + " !");
            return true;
        } else{
            System.out.println("You check your camera, but the picture is blurry.");
            return false;
        }
    }
}
