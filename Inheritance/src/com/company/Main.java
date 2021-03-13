package com.company;

public class Main {

    public static void main(String[] args) {
	    /*Animal animal = new Animal("Animal", 1, 1, 5, 5);
	    Dog dog = new Dog("Yolkie", 8, 5, 2, 4, 1, 20, "long silky");*/
	    //dog.eat();
	    //dog.walk();
	    //dog.run();
/*		Cat meow = new Cat("meow");
		Cat garfield = new Cat("garfield");
		meow.printName();
		garfield.printName();*/

       /* Tesla tesla = new Tesla(3);
        tesla.steer(45);
        tesla.accelerate(30);
        tesla.accelerate(20);*/

        /*Circle circle = new Circle(3.75);
        System.out.println("circle.radius= " + circle.getRadius());
        System.out.println("circle.area= " + circle.getArea());
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("cylinder.radius= " + cylinder.getRadius());
        System.out.println("cylinder.height= " + cylinder.getHeight());
        System.out.println("cylinder.area= " + cylinder.getArea());
        System.out.println("cylinder.volume= " + cylinder.getVolume());*/

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width: " + rectangle.getWidth());
        System.out.println("rectangle.length: " + rectangle.getLength());
        System.out.println("rectangle.area: " + rectangle.getArea());
        Cuboid cuboid = new Cuboid(5, 10, 5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.volume= " + cuboid.getVolume());
    }
}
