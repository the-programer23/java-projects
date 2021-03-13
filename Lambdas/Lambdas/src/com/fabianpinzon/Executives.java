package com.fabianpinzon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Executives {
    private String name;
    private int age;

    public Executives(String name, int wage) {
        this.name = name;
        this.age = wage;
    }

    public static void main(String[] args) {
        Executives fabian = new Executives("Fabian Pinzon", 32);
        Executives tim = new Executives("Tim Buchalka", 55);
        Executives john = new Executives("John Smith", 23);
        Executives carlos = new Executives("Carlos Santana", 18);

        List<Executives> executives = new ArrayList<>();
        executives.add(fabian);
        executives.add(tim);
        executives.add(john);
        executives.add(carlos);

       /* System.out.println("Executives over 30:");
        System.out.println("==============");
        executives.forEach(executive -> {
            if (executive.getAge() > 30){
                System.out.println(executive.getName());
            }
        });
        System.out.println("Executives under 30:");
        System.out.println("==============");
        executives.forEach(executive -> {
            if(executive.getAge() < 30){
                System.out.println(executive.getName());
            }
        });*/

        //this is called an enhanced for loop
    /*    for (Executives executive : executives){
            if (executive.getAge() > 30){
                System.out.println(executive.getName());
            }
        }*/

        /*executives.forEach(executive -> {
            System.out.println(executive.getName() + ": " + executive.getWage());
        });*/


/*

        for (Executives executive : executives){
            System.out.println(executive.getName());
            new Thread(() -> System.out.println(executive.getWage())).start();
        }
*/

        /*for (int i = 0; i<executives.size(); i++){
            Executives executive = executives.get(i);
            System.out.println(executive.getName());
            new Thread(() -> System.out.println(executive.getWage())).start();
        }*/

        getExecutivesByAge(executives, "Executives over 30", executive -> executive.getAge() > 30);
        getExecutivesByAge(executives, "\nExecutives under 30", executive -> executive.getAge() < 30);
        getExecutivesByAge(executives, "\n18 year old executives", new Predicate<Executives>() {
            @Override
            public boolean test(Executives executive) {
                return executive.getAge() == 18;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));

        int a = 20;
        System.out.println(greaterThan15.test(a + 5));
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(10));

        Random random = new Random();
        System.out.println("\n***********************");
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        for (int i = 0; i<10; i++){
            System.out.println(randomSupplier.get());
        }
        System.out.println("\n***********************");
        executives.forEach(executive -> {
            String lastName = executive.getName().substring(executive.getName().indexOf(' ') + 1);
            System.out.println("Lastname: " + lastName);
        });
    }

    public static void getExecutivesByAge(List<Executives> executives, String ageText, Predicate<Executives> ageCondition){
        System.out.println(ageText);
        System.out.println("=================");
        for (Executives executive: executives){
            if(ageCondition.test(executive)){
                System.out.println(executive.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
