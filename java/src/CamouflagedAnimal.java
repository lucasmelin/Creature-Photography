/**
 * Models a sub class CamouflagedAnimal which inherits from Creature.
 *
 * Date created: Nov 15, 2018
 * Date last modified: Nov 20, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
public class CamouflagedAnimal extends Creature{

    // Member fields belonging to the sub class
    public int camouflageAbility;
    public boolean activeCamouflage;

    /**
     * Default constructor.
     * @param name the animal's name
     * @param speed the animal's speed
     * @param camouflageAbility the animal's natural ability to camouflage
     * @param activeCamouflage  indicates if the animal's camouflage is active or passive
     */
    public CamouflagedAnimal(String name, int speed, int camouflageAbility, boolean activeCamouflage) {
        // Invoke the super class (Creature) constructor
        super(name, speed);
        // Set the fields belonging to the sub class (CamouflagedAnimal)
        this.camouflageAbility = camouflageAbility;
        this.activeCamouflage = activeCamouflage;
    }

    /**
     * Overrides the method `getTotalSpeed` inherited from `Creature` and returns
     * the speed obtained from the super method, multiplied by the camouflage bonus,
     * since camouflaged animals are more difficult to spot and photograph.
     * @return the speed calculated from the base class multiplied by the camouflage bonus
     */
    @Override
    public int getTotalSpeed(){
        // Get the total speed calculated from the Creature class
        int baseSpeed = super.getTotalSpeed();
        // If the creature has active camouflage, add a x3 multiplier
        int camouflageModifier = activeCamouflage ? 1 : 3;
        return baseSpeed * camouflageAbility * camouflageModifier;
    }

}
