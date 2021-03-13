package com.fabianpinzon;

public class Main {

    public static void main(String[] args) {
	/* SomeClass one = new SomeClass("One");
	 SomeClass two = new SomeClass("Two");
	 SomeClass three = new SomeClass("Three");

		System.out.println(one.getInstanceNumber());
		System.out.println(two.getInstanceNumber());
		System.out.println(three.getInstanceNumber());

		//one.instanceNumber = 4;
		System.out.println(Math.PI);

		int password = 1234;
		Password password1 = new ExtendedPassword(password);
		password1.storePassword();

		password1.letMeIn(1293);
		password1.letMeIn(0);
		password1.letMeIn(-1);
		password1.letMeIn(1234);*/
		System.out.println("Main method called");
		SIBTest test = new SIBTest();
		test.someMethod();
		System.out.println("Owner is " + SIBTest.owner);
    }
}
