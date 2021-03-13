package com.company;

public class Main {

    public static void main(String[] args) {
      /*  Dimensions dimensions = new Dimensions(20, 20, 5);
	    Case theCase = new Case("220B", "Dell", "240", dimensions);

        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePc = new PC(theCase, theMonitor, theMotherboard);
        thePc.powerUp();*/

        Wall wall1 = new Wall("north");
        Wall wall2 = new Wall("south");
        Wall wall3 = new Wall("east");
        Wall wall4 = new Wall("west");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 1, 1);
        Lamp lamp = new Lamp("Classic", false, 71);

        Bedroom bedRoom = new Bedroom("Fabians", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedRoom.getLamp().turnOn();
        bedRoom.makeBed();

    }
}
