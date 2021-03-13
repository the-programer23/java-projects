package com.company;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        return "Car -> startEngine()";
    }

    public String accelerate(){
        return "Car -> accelerate()";
    }

    public String brake(){
        return "Car -> brake";
    }
}

class Ferrari extends Car {

    public Ferrari(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ferrari -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Ferrari -> accelerate()";
    }

    @Override
    public String brake() {
        return "Ferrari -> brake()";
    }
}

class Lamborghini extends Car {

    public Lamborghini(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return  getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Lamborghini -> accelerate()";
    }

    @Override
    public String brake() {
        return "Lamborghini -> brake()";
    }
}

class Tesla extends Car {

    public Tesla(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Tesla -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Tesla -> accelerate()";
    }

    @Override
    public String brake() {
        return "Tesla -> brake()";
    }
}


public class Main {

    public static void main(String[] args) {
	    Car car = new Car(4, "Base Car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Ferrari ferrari = new Ferrari(6, "F8 Tributo");
        System.out.println(ferrari.startEngine());
        System.out.println(ferrari.accelerate());
        System.out.println(ferrari.brake());

        Tesla tesla = new Tesla(6, "Model s");
        System.out.println(tesla.startEngine());
        System.out.println(tesla.accelerate());
        System.out.println(tesla.brake());

        Lamborghini lamborghini = new Lamborghini(6, "Model s");
        System.out.println(lamborghini.startEngine());
        System.out.println(lamborghini.accelerate());
        System.out.println(lamborghini.brake());
    }


}
