package com.company;

import java.util.ArrayList;

class intClass {
    private int myIntValue;

    public intClass(int myIntValue) {
        this.myIntValue = myIntValue;
    }

    public int getMyIntValue() {
        return myIntValue;
    }

    public void setMyIntValue(int myIntValue) {
        this.myIntValue = myIntValue;
    }
}

public class Main {

    public static void main(String[] args) {
	 String[] strArray = new String[10];
	 int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Fabian");

        // ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<intClass> intClassArrayList = new ArrayList<intClass>();
        intClassArrayList.add(new intClass(23));

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for(int i = 0; i <= 10; i++){
            intArrayList.add(Integer.valueOf(i));
        }
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " ====> " + intArrayList.get(i).intValue());
        }
        System.out.println("\n//////////////////////////");

        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for(double i = 0.0; i <= 10.0; i += 0.5){
            doubleArrayList.add(i);
        }
        for(int i = 0; i < doubleArrayList.size(); i++){
            System.out.println(i + " ---> " + doubleArrayList.get(i));
        }
    }
}
