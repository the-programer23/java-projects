package com.company;

public class Main {

    public static void main(String[] args) {
/*	 Hamburger hamburger = new Hamburger("white", "El Toro", "sausage", 3.54);
	 hamburger.itemizeHamburger();
	 hamburger.addHamburgerAddition1("Tomato" , 0.75);
	 hamburger.addHamburgerAddition2("Cheese", 0.95);
     hamburger.addHamburgerAddition3("lettuce", 0.35);
     System.out.println("The total burger price is: " + hamburger.itemizeHamburger());*/

     /*HealthyBurger healthyBurger = new HealthyBurger("Cultured Meat", 9.67);
     healthyBurger.addHamburgerAddition1("egg", 2.1);
     healthyBurger.addHealthyAddition1("lentils", 3.5);
     healthyBurger.addHealthyAddition2("Broccoli", 2.25);
     System.out.println("The total healthy burger price is: " + healthyBurger.itemizeHamburger());*/

     DeluxeBurger deluxeBurger = new DeluxeBurger();
     deluxeBurger.addHamburgerAddition3("not allowed addition", 50.5);
     System.out.println("The total Deluxe Burger price is: " + deluxeBurger.itemizeHamburger());
    }
}
