package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    /*int[] myIntArray = new int[5];
	    int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        anotherArray = new int[] {2, 3, 6, 8, 9};
        modifyArray(myIntArray);

        System.out.println("after modify myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after modify anotherArray = " + Arrays.toString(anotherArray));*/
 /*       System.out.println("Enter the number of elements the array should have");
        int count = scanner.nextInt();
        int[] intArray = readIntegers(count);
        System.out.println("The minimum value in the array is = " + findMin(intArray));*/
        int[] array = { 1, 4, 7, 34, 58, 14, 105, 67};
        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed array is = " + Arrays.toString(array));

    }


    public static int[] readIntegers(int count){
        System.out.println("Please, enter 5 integer numbers");
        int[] intArray = new int[count];
        for (var i = 0; i < intArray.length; i++){
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    public static int findMin(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }
    //{ 1, 4, 7, 34, 58, 14, 105, 67};

    //reverse an array
    public static void reverse(int[] array){
        int maxIndex = array.length - 1; // 8
        int halfLength = array.length / 2; // 4
        for(int i = 0; i < halfLength; i++){
            int temp = array[i]; // 1, 4, 7
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }
}
