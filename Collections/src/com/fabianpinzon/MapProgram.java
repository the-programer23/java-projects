package com.fabianpinzon;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        //String, String is the key and the value respectively
        Map<String, String> languages = new HashMap<>();
        System.out.println(languages.put("Java", "a compiled high level, object-oriented, platform independent language"));
        languages.put("Python", "an interpreted, object-oriented, high-level programming language");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "beginners All Purposes Symbolic instruction code");

        if(languages.containsKey("Python")){
            System.out.println("Python is already in the map");
        }else {
            System.out.println(languages.put("Python", "Created by Guido van Rossum"));
            System.out.println(languages.get("Python"));
        }

        //System.out.println(languages.get("BASIC"));
        //languages.put("BASIC", "The original version was designed by John G. Kemeny and Thomas E. Kurtz and released at Dartmouth College in 1964");
        //System.out.println(languages.get("BASIC"));
        System.out.println("============================");

        //languages.remove("Algol");
        if(languages.remove("BASIC", "An old programming language")){
            System.out.println("BASIC removed");
        }else {
            System.out.println("BASIC not removed key/value pair not found");
        }

        if(languages.replace("Python", "an interpreted, object-oriented, high-level programming language", "A programming language than I may learn in the future")){
            System.out.println("Python replaced");
        }else {
            System.out.println("Python not replaced");
        }
        //System.out.println(languages.replace("Kotlin", "It will not be replaced"));
        for(String key : languages.keySet()){
            System.out.println(key + ": " + languages.get(key));
        }

    }
}
