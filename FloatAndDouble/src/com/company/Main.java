package com.company;

public class Main {

    public static void main(String[] args) {
	    float myMinFloatValue = Float.MIN_VALUE;
	    float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5.00 / 3.00;
        System.out.println("my Int number is " + myIntValue);
        System.out.println("my float value is " + myFloatValue);
        System.out.println("my double value is " + myDoubleValue);

        int pounds = 5;
        double kilograms = pounds / 2.205;
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");

        double pi = 3.1415297d;
        double anotherNumber = 3_000_000.4_003_496d;
        System.out.println(pi);
        System.out.println(anotherNumber);
    }
}
