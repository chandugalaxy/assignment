package com.suncorp.banking.mock;

import com.suncorp.banking.dto.Account;
import com.suncorp.banking.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    private static List<Account> accounts;

    public static List<Account> getAccounts() {
        if(accounts == null) {
            accounts.add(new Account(1, "Savings", "One", "Test", "01-Jan-1990", populateTransactions(), "01-Jan-2018", null));
            accounts.add(new Account(2, "Savings", "Two", "Test", "01-Feb-1990", populateTransactions(), "01-Feb-2018", null));
            accounts.add(new Account(3, "Deposit", "Three", "Test", "01-Mar-1990", populateTransactions(), "01-Mar-2018", null));
            accounts.add(new Account(4, "Deposit", "Four", "Test", "01-Apr-1990", populateTransactions(), "01-Apr-2018", null));
            accounts.add(new Account(5, "Savings", "Five", "Test", "01-May-1990", populateTransactions(), "01-May-2018", null));
        }
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    private static List<Transaction> populateTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(111, "trx1", "success", "03-May-2018", "Credit", BigDecimal.valueOf(100)));
        transactions.add(new Transaction(111, "trx1", "success", "03-May-2018", "Credit", BigDecimal.valueOf(100)));
        transactions.add(new Transaction(111, "trx1", "success", "03-May-2018", "Credit", BigDecimal.valueOf(100)));
        transactions.add(new Transaction(111, "trx1", "success", "03-May-2018", "Credit", BigDecimal.valueOf(100)));
        return transactions;
    }
}
