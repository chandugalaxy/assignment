package com.suncorp.banking.dto;

import com.suncorp.banking.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class Account {

    private Integer accountNumber;
    private String accountType;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private String creationDate;
    private String modifiedDate;

    public Account() {
    }

    public Account(Integer accountNumber, String accountType, String firstName, String lastName, String dateOfBirth, List<Transaction> transactions, String creationDate, String modifiedDate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.transactions = transactions;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public Integer getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
