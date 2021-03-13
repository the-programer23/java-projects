package com.company;

public class Animal {
    private String name;
    private int brain;
    private int size;
    private int body;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.size = size;
        this.body = body;
        this.weight = weight;
    }

    public void move(int speed){
        System.out.println("Animal.move() called. Animal moves to a speed of " + speed);
    }

    public void eat(){
        System.out.println("Animal.eat() method called");
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getSize() {
        return size;
    }

    public int getBody() {
        return body;
    }

    public int getWeight() {
        return weight;
    }
}
