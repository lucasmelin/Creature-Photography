public class Car extends Vehicle{

    // One extra field
    public int wheels;

    public Car(int speed, String colour, int wheels) {
        // Call to the super method (Vehicle)
        super(speed, colour);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

}
