package com.fabianpinzon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Challenges {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String myString = "Let's split this into an array";
            String[] parts = myString.split(" ");
            for (String part : parts){
                System.out.println(part);
            }

        };
        runnable.run();
       String val = everySecondChar(lambdaFunction);
        System.out.println(val);

        Supplier<String> iLoveJava = () -> "I love java";
        System.out.println(iLoveJava.get());

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> sortedNames = new ArrayList<>();
        topNames2015.forEach(s -> sortedNames.add(s.substring(0,1).toUpperCase() + s.substring(1)));
        /*sortedNames.sort((s1, s2) -> s1.compareTo(s2));
        sortedNames.forEach(s -> System.out.println(s));*/
     /*   sortedNames.sort(String::compareTo);
        sortedNames.forEach(System.out::println);*/

       /* topNames2015.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);*/
        /*topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .forEach(s -> System.out.println(s));*/
       /* List<String> ANames = new ArrayList<>();
        topNames2015.forEach(name -> {
            if (name.startsWith("A")){
                ANames.add(name);
            }
        });
        ANames.forEach(AName -> System.out.println(AName) );*/

        long count = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .peek(System.out::println)
                .count();
        System.out.println(count);

    }

    public static String everySecondChar(Function<String, String> lambdaFunction){
      return lambdaFunction.apply("1234567890");
    };

    static Function<String, String> lambdaFunction = s -> {
        StringBuilder returnVal = new StringBuilder();
        returnVal.append(s);
        for (int i = 0; i<s.length(); i++){
            if (i % 2 == 1){
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();
    };


}
