package com.fabianpinzon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    new Thread(new CodeToRun()).start();

	    new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second runnable");
            }
        }).start();

	    //With Lambda expression
        new Thread(()-> {
            System.out.println("This is a lambda expression");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();

    }
}


class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}
