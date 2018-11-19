public class Hatchback extends Car {

    // One extra field
    public int doors;
    // Hiding of the colour field from the Vehicle class
    public String colour;

    public Hatchback(int speed, String colour, int wheels, int doors) {
        super(speed, colour, wheels);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }


    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }
}
