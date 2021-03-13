package com.company;

public class Main {

    public static void main(String[] args) {
	   /* Player player = new Player();
	    player.name = "Fabian";
	    player.health = 20;
	    player.weapon = "Sword";

	    int damage = 10;
	    player.health = 10000;
	    player.loseHealth(damage);

        System.out.println("Remaining health= " + player.healthRemaining());*/
		/*EnhancedPlayer player = new EnhancedPlayer("Fabian", 110, "sword");
		System.out.println(player.getHitPoints());*/

        Printer printer = new Printer(50,true);
        System.out.println("Initial page count = " + printer.getPrintedPages());
        int pagesPrinted = printer.print(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count for printer is " + printer.getPrintedPages());
        pagesPrinted = printer.print(2);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count for printer is " + printer.getPrintedPages());

    }
}
