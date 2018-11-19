public class Vehicle {

    // Two public fields
    public int speed;
    public String colour;

    // One private field
    private boolean hasSteeringWheel;

    // Constructor
    public Vehicle(int speed, String colour) {
        this.speed = speed;
        this.colour = colour;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isHasSteeringWheel() {
        return hasSteeringWheel;
    }

    public void setHasSteeringWheel(boolean hasSteeringWheel) {
        this.hasSteeringWheel = hasSteeringWheel;
    }
}
