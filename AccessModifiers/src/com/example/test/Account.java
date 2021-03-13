package com.example.test;

import java.util.ArrayList;

public class Account implements Accessible{
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount > 0){
            this.transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " was deposited. The new balance is " + this.balance);
        }else {
            System.out.println("Can not deposit negative sums");
        }
    }

    public void withdraw(int amount){
        int withdrawal = -amount;
        if(withdrawal < 0){
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount + " withdrawn. The new balance is " + this.balance);
        }else {
            System.out.println("Can not withdraw negative sums");
        }
    }

    public void calculateBalance(){
        this.balance = 0;
        for(int i : this.transactions){
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public boolean methodC() {
        return false;
    }
}
