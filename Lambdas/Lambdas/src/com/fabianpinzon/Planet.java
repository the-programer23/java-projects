package com.fabianpinzon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Planet {
    private String name;
    private int orbit;

    public Planet(String name, int orbit) {
        this.name = name;
        this.orbit = orbit;
    }

    public static void main(String[] args) {
        Planet earth = new Planet("Earth Ocean", 3);
        Planet mars = new Planet("Mars Red", 4);
        Planet jupiter = new Planet("Jupiter Gas", 5);

        List<Planet> planets = new ArrayList<>();

        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);

        Function<Planet, String> getCharacteristic = (Planet planet) -> planet.getName().substring(planet.getName().indexOf(' ') + 1);

        String characteristic = getCharacteristic.apply(planets.get(2));
        System.out.println(characteristic);



        Function<Planet, String> getPlanet = (Planet planet) -> planet.getName().substring(0, planet.getName().indexOf(' '));

        Random random = new Random();

        for (Planet planet : planets){
            if (random.nextBoolean()){
                System.out.println(getRandomSubstring(getCharacteristic, planet));
            }else {
                System.out.println(getRandomSubstring(getPlanet, planet));
            }
        }

        Function<Planet, String> upperCaseAll = planet -> planet.getName().toUpperCase();
        Function<String, String> upperCasedPlanet = planet -> planet.substring(0, planet.indexOf(' '));
        Function chainFunction = upperCaseAll.andThen(upperCasedPlanet);
        System.out.println(chainFunction.apply(planets.get(1)));


        BiFunction<String, Planet, String> concatOrbit = (String uppercasePlanet, Planet planet) -> uppercasePlanet.concat(" " + planet.getOrbit());

        String upperCasedString = upperCaseAll.apply(planets.get(0));
        System.out.println(concatOrbit.apply(upperCasedString, planets.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);

        c1.andThen(c2).accept("Hello world");
    }


    private static String getRandomSubstring(Function<Planet, String> subString, Planet planet){
        return subString.apply(planet);
    };

    public String getName() {
        return name;
    }

    public int getOrbit() {
        return orbit;
    }
}
