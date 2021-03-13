package com.fabianpinzon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N23", "N15",
                "B12", "B53",
                "G58", "G12", "G93", "G47", "g64",
                "I12",  "I33",
                "O98"
        );

        List<String> gNumbers = new ArrayList<>();

        bingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
            }
        });
        //Long old way

        //Arrange gNumbers in ascending order
        //gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.sort(Comparator.naturalOrder());
        gNumbers.forEach(number -> System.out.println(number));
        //gNumbers.forEach(System.out::println);

        //New short way
        System.out.println("\n********************");
        bingoNumbers.stream()
                //.map(s->s.toUpperCase())
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumbersStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumbersStream, inNumberStream);
        System.out.println("------------------------");
        //This line removes the duplicates (4 items)
        System.out.println(concatStream.
                distinct().
                peek(System.out::println).
                count());

        Actor brad = new Actor("Brad Pitt", 57);
        Actor julia = new Actor("Julia Roberts", 53);
        Actor jim = new Actor("Jim Carrey", 59);
        Actor arnold = new Actor("Arnold Schwarzenegger", 73);

        Movie titanic = new Movie("Titanic");
        titanic.addActor(julia);
        titanic.addActor(jim);
        titanic.addActor(arnold);

        Movie fightClub = new Movie("Fight Club");
        fightClub.addActor(brad);

        List<Movie> movies = new ArrayList<>();
        movies.add(titanic);
        movies.add(fightClub);

        System.out.println("*****************");

        movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .forEach(actor -> System.out.println(actor.getName()));

        System.out.println("---------------------");
       /*List<String> sortedGNumbers = bingoNumbers
               .stream()
               .map(String::toUpperCase)
               .filter(n -> n.startsWith("G"))
               .sorted()
               .collect(Collectors.toList());*/
       List<String> sortedGNumbers = bingoNumbers
               .stream()
               .map(String::toUpperCase)
               .filter(n -> n.startsWith("G"))
               .sorted()
               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

       for (String s : sortedGNumbers){
           System.out.println(s);
       }
        System.out.println("***************");

        Map<Integer, List<Actor>> groupedByAge = movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .collect(Collectors.groupingBy(actor -> actor.getAge()));

        //the reduce method gets the youngest actor
        System.out.println("The youngest actor is: ");
        movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .reduce((actor1, actor2) -> actor1.getAge() < actor2.getAge() ? actor1 : actor2)
                .ifPresent(actor -> System.out.println(actor.getName() + ": " + actor.getAge()));
        String[] heroes = {"Superman", "Batman", "Superwoman", "Robin"};
        Stream.of(heroes)
                .filter(hero -> {
                    if (hero.startsWith("Super")){
                        System.out.println(hero);
                    }
                    return hero.startsWith("Super");
                }).count();

    }
}
