package com.fabianpinzon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    static void beforeAll(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    void setup(){
        account = new BankAccount("Fabian", "Pinzon", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200,balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400, balance, 0);
    }



    @Test
    void withdraw_notBranch(){
        //Old way
        /*try{
            account.withdraw(600.00, false);
            fail("should have thrown an IllegalArgumentException");
        }catch(IllegalArgumentException e){

        }*/

        //New way
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    account.withdraw(600, false);
                    fail("Should have thrown an IllegalArgumentException");
                }
        );
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance());
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance());
    }

    @org.junit.jupiter.api.Test
    void isChecking_true(){
        //When the expected value is different from the result, the second argument message is shown in the console
        assertTrue(account.isChecking(), "The account is not a checking account");
    }

    @org.junit.jupiter.api.AfterAll
    static void AfterAll(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown(){
        System.out.println("Count = " + count++);
    }

}