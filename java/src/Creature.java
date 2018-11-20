import java.util.Random;

/**
 * Models a base Creature class which contains a name and speed.
 *
 * Date created: Nov 15, 2018
 * Date last modified: Nov 20, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
public class Creature {

    public String name;
    public int speed;

    /**
     * Default Creature constructor.
     * @param name the creature's name
     * @param speed the speed of the creature
     */
    public Creature(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    /**
     * Overrides the `toString` method in the super class Object.
     * @return a string representation of the creature's name and speed
     */
    @Override
    public String toString() {
        return "Creature " + this.name + " with a speed of " + this.speed;
    }

    /**
     * Multiplies the creature's speed by a random number from 1-20 inclusive
     * @return an integer representing the creature's total speed
     */
    public int getTotalSpeed(){
        Random random = new Random();
        return (random.nextInt(19) + 1) * this.speed;
    }
}
