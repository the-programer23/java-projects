package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

    //returns an array of entered integers from keyboard
    public static int[] getIntegers(int capacity){
        System.out.println("Enter 5 integer values\r");

        int[] enteredValuesArray = new int[capacity];

        for(var i = 0; i < enteredValuesArray.length; i++){
            enteredValuesArray[i] = scanner.nextInt();
        }

        return enteredValuesArray;
    }

    //prints out the content of the array
    public static void printArray(int[] array){
        for(var i = 0; i < array.length; i++){
            System.out.println("Element " + i + " typed value was " + array[i]);
        }
    }

    //Sort the array in a descending order and returns new array containing the sorted numbers
    public static int[] sortIntegers(int[] array){
        /*int[] sortedArray = new int[array.length];
        for(var i = 0; i < array.length; i++){
            sortedArray[i] = array[i];
        }*/
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;
        // sortedArray[0] = 18 temp = 18, sortedArray[0] = 180, sortedArray[0 + 1] = 18
        // sortedArray[1] = 180
        // sortedArray[2] = 53
        while(flag){
            flag = false;
            for(var i = 0; i < sortedArray.length -1; i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

}
