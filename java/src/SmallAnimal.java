/**
 * Models a sub class SmallAnimal which inherits from Creature.
 *
 * Date created: Nov 15, 2018
 * Date last modified: Nov 20, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
public class SmallAnimal extends Creature {

    /**
     * Default constructor.
     * @param name the small animal's name
     * @param speed the small animal's speed
     */
    public SmallAnimal(String name, int speed) {
        // Invoke the super class (Creature) constructor
        super(name, speed);
    }

    /**
     * Overrides the method `getTotalSpeed` inherited from `Creature` and returns
     * the speed obtained from the base method, divided by 2, since smaller creatures
     * cannot move as quickly.
     * @return the speed calculated from the super class divided by 2
     */
    @Override
    public int getTotalSpeed(){
        int baseSpeed = super.getTotalSpeed();
        return baseSpeed / 2;
    }
}
