package com.example;

// To Use:
// [X] Assert.assertEquals
// [X] @BeforeClass
// [X] @AfterClass
// [X] expectedExceptions
// [X] @DataProvider
// [X] Group for positive tests
// [X] Group for negatice tests
// [X] Run only negative tests using testng.xml\
// [X] Write a dependant test of a successful deposit before withdrawal. 

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BankAccountTest {

    private BankAccount account = new BankAccount(0);

    @BeforeClass
    public void beforeClass() {
        System.out.println("Iniciando clase de pruebas");
        account = new BankAccount(0);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Finalizando clase de pruebas");
        account = null;
    }

    @BeforeMethod
    public void setUp() {
        // Reset account before each test
        account = new BankAccount(0);
    }

    // DataProvider for parameterized deposit tests
    @DataProvider(name = "amounts")
    public Object[][] createAmounts() {
        return new Object[][] {
            { 10.0, 110.0 },
            { 20.0, 120.0 },
            { 30.0, 130.0 }
        };
    }

    // INITIAL TEST EXECUTES FOR POSITIVE & NEGATIVE.

    @Test(groups = {"positive", "negative"})
    public void assureInitialBalance() {
        Assert.assertEquals(account.getBalance(), 0);
    }

    // POSITIVE TESTS.
    
    // Positive test: Deposit
    @Test(groups = {"positive"})
    public void testDeposit() {
        account.deposit(50);
        Assert.assertEquals(account.getBalance(), 50);
    }

    // Positive test: Withdraw, depends on successful deposit.
    @Test(groups = {"positive"}, dependsOnMethods = "testDeposit")
    public void testWithdraw() {
        account.withdraw(30.0);
        Assert.assertEquals(account.getBalance(), 20.0);
    }

    // Positive test: Deposit using DataProvider.
    @Test(dataProvider = "amounts", groups = {"positive"})
    public void testDepositWithDataProvider(double depositAmount, double expectedBalance) {
        BankAccount newAccount = new BankAccount(100.0);
        newAccount.deposit(depositAmount);
        Assert.assertEquals(newAccount.getBalance(), expectedBalance);
    }

    // NEGATIVE TESTS.

    // Negative test: Deposit negative amount.
    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-10.0);
    }

    // Negative test: Withdraw negative amount.
    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-10.0);
    }

    // Negative test: Withdraw more than balance.
    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.withdraw(1000.0);
    }
}