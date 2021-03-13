package com.fabianpinzon;

public class Main {

    public static void main(String[] args) {
	 BankAccount account = new BankAccount(1000.00, "12345-678");

	/* new Thread(() -> {
        account.deposit(300.00);
        account.withdraw(50.00);
     }).start();

	 new Thread(() -> {
	     account.deposit(203.75);
	     account.withdraw(100.00);
     }).start();*/

        Thread trThread1 = new Thread(() -> {
            account.deposit(300.00);
            account.withdraw(50.00);

        });

        Thread trThread2 = new Thread(() -> {
            account.deposit(203.75);
            account.withdraw(100.00);

        });

        trThread1.start();
        trThread2.start();
    }
}
