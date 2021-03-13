package com.fabianpinzon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class BankAccountTestParameterized {
    private BankAccount account;
  /*  private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }*/

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Fabian", "Pinzon", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    @MethodSource("testCollections")
    void deposit(double amount, boolean branch, double expected){
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }

    public static Collection<Object[]> testCollections(){
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }


}
