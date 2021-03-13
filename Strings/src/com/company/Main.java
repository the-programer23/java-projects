package com.company;

public class Main {

    public static void main(String[] args) {
	    String myString = "10";
	    int myInt = 50;
	    myString = myString + myInt;
        System.out.println(myString);

        double doubleNumber = 127.47d;
        myString = myString + doubleNumber;
        System.out.println(myString);

        // Challenge

        double firstDouble = 20.00;
        double secondDouble = 80.00;
        double total = (firstDouble + secondDouble) * 100.00;
        System.out.println("Total is: " + total);
        double remainder = total % 40.00d;
        System.out.println("The remainder is: " + remainder);
        boolean isRemainderEqualsZero = remainder == 0 ? true : false;
        System.out.println(isRemainderEqualsZero);

        if(!isRemainderEqualsZero){
            System.out.println("Got some remainder?");
        }
    }
}
