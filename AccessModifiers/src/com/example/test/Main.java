package com.example.test;

public class Main {

    public static void main(String[] args) {
	    Account fabiansAccount = new Account("Fabian");
	    fabiansAccount.deposit(100);
	    fabiansAccount.withdraw(20);
	    fabiansAccount.deposit(-50000000);
	    fabiansAccount.withdraw(-10000);
	    fabiansAccount.calculateBalance();
		System.out.println("Balance on account is " + fabiansAccount.getBalance());

		System.out.println("SOME_CONSTANT is "+  fabiansAccount.SOME_CONSTANT);
    }
}
