package com.company;

public class Car extends Vehicle{

    private int doors;
    private int wheels;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int doors, int wheels, int gears, boolean isManual) {
        super(name, size);
        this.doors = doors;
        this.wheels = wheels;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        setCurrentGear(this.currentGear);
    }

    public void changeVelocity(int speed, int direction){
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direction " + direction);
        move(speed, direction);
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear set to: " + this.currentGear);
    }
}
