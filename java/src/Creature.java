public class Creature {

    public String name;
    public int speed;

    public Creature(String name, int speed) {
        this.name = name;
        this.speed = speed;

    }

    @Override
    public String toString() {
        return "Creature " + this.name + " with a speed of " + this.speed;
    }
}
