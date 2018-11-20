/**
 * Models a sub class Human which inherits from Creature.
 *
 * Date created: Nov 15, 2018
 * Date last modified: Nov 20, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
public class Human extends Creature {

    /**
     * Default constructor.
     * @param name the human's name
     * @param speed the human's speed, or shutter speed if representing a photographer
     */
    public Human(String name, int speed) {
        // Invokes the super class (Creature) constructor
        super(name, speed);
    }

    /**
     * Attempt to photograph the creature by comparing the human's shutter speed and the creature speed.
     * @param creature the creature to photograph
     * @return true if the picture was taken successfully, false otherwise
     */
    public boolean photograph(Creature creature) {
        // We can refer to `this.name` without having to reference the super class first
        System.out.println(this.name + " attempts to photograph " + creature.name);

        // Calls the super class' `getTotalSpeed` method
        int shutterSpeed = this.getTotalSpeed();
        // Calls the `getTotalSpeed` method if present in the creature type's class, otherwise
        // will call the `getTotalSpeed` method in the Creature super class
        int evasionSpeed = creature.getTotalSpeed();

        System.out.println("You snap a picture with a speed of " + shutterSpeed);
        System.out.println(creature.name + " runs away with a speed of " + evasionSpeed);

        if (shutterSpeed >= evasionSpeed) {
            System.out.println("You check your camera, and you have a clear picture of the " + creature.name + "!");
            return true;
        } else{
            System.out.println("You check your camera, but the picture is blurry.");
            return false;
        }
    }
}
