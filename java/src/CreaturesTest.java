import static org.junit.jupiter.api.Assertions.*;

/**
 * This file contains tests of the Creatures super class and its sub classes.
 *
 * Date created: Nov 20, 2018
 * Date last modified: Nov 20, 2018
 * @version Java 1.8
 * @author Lucas Melin
 */
class CreaturesTest {

    /**
     * Verify that a Human is also of type Creature.
     * Lucas Melin
     */
    @org.junit.jupiter.api.Test
    public void humanIsCreatureTest(){
        Human human = new Human("Joe", 1);
        assertTrue(human instanceof Creature);
    }

    /**
     * Verify that a Human inherits the `name` field from Creature.
     */
    @org.junit.jupiter.api.Test
    public void humanHasNameTest(){
        Human human = new Human("Frank", 1);
        assertEquals(human.name, "Frank");
    }

    /**
     * Verify that a SmallAnimal is also of type Creature.
     */
    @org.junit.jupiter.api.Test
    public void smallAnimalIsCreatureTest(){
        SmallAnimal smallAnimal = new SmallAnimal("Guinea pig", 12);
        assertTrue(smallAnimal instanceof Creature);
    }

    /**
     * Verify that a SmallAnimal inherits the `name` field from Creature.
     */
    @org.junit.jupiter.api.Test
    public void smallAnimalHasNameTest(){
        SmallAnimal smallAnimal = new SmallAnimal("Chinchilla", 8);
        assertEquals(smallAnimal.name, "Chinchilla");
    }

    /**
     * Verify that a CamouflagedAnimal is also of type Creature.
     */
    @org.junit.jupiter.api.Test
    public void camouflagedAnimalIsCreatureTest(){
        CamouflagedAnimal camouflagedAnimal = new CamouflagedAnimal("Deer", 20, 2, false);
        assertTrue(camouflagedAnimal instanceof Creature);
    }

    /**
     * Verify that a CamouflagedAnimal inherits the `name` field from Creature.
     */
    @org.junit.jupiter.api.Test
    public void camouflagedAnimalHasNameTest(){
        CamouflagedAnimal camouflagedAnimal = new CamouflagedAnimal("Deer", 20, 2, false);
        assertEquals(camouflagedAnimal.name, "Deer");
    }
}