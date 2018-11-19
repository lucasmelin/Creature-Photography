class Exercise05{
    public static void main(String[]args){
        Vehicle vehicle=new Vehicle(200,"blue");
        Car car=new Car(150,"green",4);
        Hatchback hatchback=new Hatchback(100,"red",4,5);

        if (hatchback instanceof Vehicle){
            System.out.println(hatchback+" is a Vehicle");
        }
        if (hatchback instanceof Car){
            System.out.println(hatchback+" is a Car");
        }

        System.out.println("Speed from Vehicle class : " + hatchback.getSpeed());
        System.out.println("Wheels from Car class : " + hatchback.getWheels());
        System.out.println("Doors from Hatchback class : " + hatchback.getDoors());
    }
}

