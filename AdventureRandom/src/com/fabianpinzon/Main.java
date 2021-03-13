package com.fabianpinzon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {
        System.out.println("main");
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        Location currentLocation = locations.getLocation(1);
        while (true) {
            System.out.println(currentLocation.getDescription());

            if (currentLocation.getLocationId() == 0) {
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            System.out.println("direction: " + direction);
            if (direction.length() > 1) {
            String[] words = direction.split(" ");
                for(String word: words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }


            if (exits.containsKey(direction)) {
                System.out.println("currentLocation.getExits().get(direction) " + currentLocation.getExits().get(direction));
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction));
                System.out.println("currentLocation: " + currentLocation);
            } else {
                System.out.println("You can not go to that direction");
            }
        }
        locations.close();
    }
}
