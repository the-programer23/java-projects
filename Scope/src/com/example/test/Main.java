package com.example.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        X x = new X(new Scanner(System.in));
        x.x();


     /*   String var3 = "This is private to main()";

	    ScopeCheck scopeInstance = new ScopeCheck();
	    scopeInstance.useInner();
	    ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        System.out.println("varThree is not accessible here " + innerClass.varThree);*/


       /* System.out.println("scopeInstance varOne is = " + scopeInstance.getVarOne());
        System.out.println(var3);

        scopeInstance.timesTwo();
        System.out.println("*******************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();*/
    }
}
