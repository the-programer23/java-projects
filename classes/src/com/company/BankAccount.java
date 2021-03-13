package com.company;

public class BankAccount {
    private String number;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public BankAccount(){
        this("123", 0.00, "Default customer name", "default email", 1);
        System.out.println("Constructor with no parameters executed");
    }

    public BankAccount(String number, double balance, String customerName, String email, int phoneNumber){
        System.out.println("Account constructor with parameters called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, int phoneNumber) {
        this("9999", 0.0, customerName, email, phoneNumber);
    }

    public String number() {
        return number;
    }

    public void number(int accountNumber) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double depositAmount){
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. Your new balance is " + this.balance);
    }

    public void withdrawal(double withdrawalAmount){
        if(this.balance  - withdrawalAmount < 0){
            System.out.println("Only " + balance + " available. Withdrawal not processed." );
        }else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance = " + this.balance);
        }

    }
}
