package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        for(var i = 0; i < myIntegers.length; i++){
            System.out.println("Element " + i + " typed value was " + myIntegers[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers));
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values\r");
        //this means values.length is 4 or that is values array can only have 5 elements
        int[] values = new int[number];
        for(var i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for(var i = 0; i < array.length; i++){
            sum += array[i];
        }
        return (double)sum / (double)array.length;
    }
}
