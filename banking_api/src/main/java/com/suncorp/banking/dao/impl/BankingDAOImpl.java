package com.suncorp.banking.dao.impl;

import com.suncorp.banking.constants.BankingApiConstants;
import com.suncorp.banking.controller.BankingApiController;
import com.suncorp.banking.dao.BankingDAO;
import com.suncorp.banking.dto.Account;
import com.suncorp.banking.mock.MockData;
import com.suncorp.banking.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is the Implementationn class to handle data layer for the banking operations
 *
 * @author Chandra
 * @version 1.0
 */
@Repository
public class BankingDAOImpl implements BankingDAO {

    private static final Logger log = LoggerFactory.getLogger(BankingDAOImpl.class);

    /**
     * This method handles the operation for create account
     *
     * @param createAccountRequest
     * @return
     */
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        try {
            List<Account> accounts = MockData.getAccounts();
            Account account = new Account(accounts.size()+1, createAccountRequest.getAccountType(), createAccountRequest.getFistName(), createAccountRequest.getLastName(), createAccountRequest.getDateOfBirth(), new ArrayList<>(), new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), null);
            createAccountResponse.setAccountNumber(account.getAccountNumber());
            createAccountResponse.setStatus(BankingApiConstants.MSG_SUCCESS);
            createAccountResponse.setMessage(BankingApiConstants.MSG_ACCOUNT_CREATE_SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage());
            createAccountResponse.setStatus(BankingApiConstants.MSG_FAILURE);
            createAccountResponse.setMessage(e.getMessage());
        }
        return createAccountResponse;
    }

    /**
     * This method handles the operation of deposit funds
     *
     * @param depositRequest
     * @return
     */
    @Override
    public DepositResponse depositFunds(DepositRequest depositRequest) {
        DepositResponse depositResponse = new DepositResponse();
        try {
            Transaction transaction = depositFunds(depositRequest.getAccountNumber(), depositRequest.getAmount());
            depositResponse.setTransactionId(transaction.getTransactionId());
            depositResponse.setStatus(transaction.getTransactionStatus());
            depositResponse.setMessage(transaction.getTransactionStatus());
        } catch (Exception e) {
            log.error(e.getMessage());
            depositResponse.setStatus(BankingApiConstants.MSG_FAILURE);
            depositResponse.setMessage(e.getMessage());
        }
        return depositResponse;
    }

    /**
     * This method is an utility to deposit funds in an account
     *
     * @param accountNumber
     * @param amount
     * @return
     */
    private Transaction depositFunds(Integer accountNumber, BigDecimal amount) {
        Transaction transaction = new Transaction();
        Account providedAccount = getAccount(accountNumber);
        if(providedAccount == null) {
            log.info(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
            transaction.setTransactionStatus(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
            return transaction;
        }
        providedAccount.setBalance(providedAccount.getBalance().add(amount));
        List<Transaction> transactions = getTransactions(accountNumber);
        transaction = new Transaction(transactions.size()+1, "deposit", BankingApiConstants.MSG_SUCCESS, "", "DR", amount);
        transactions.add(transaction);
        return transaction;
    }

    /**
     * This method handles the operation get transactions of given account
     *
     * @param accountNumber
     * @return
     */
    @Override
    public List<Transaction> getTransactions(Integer accountNumber) {
        Account providedAccount = getAccount(accountNumber);
        if(providedAccount != null) {
            return providedAccount.getTransactions();
        } else {
            return null;
        }
    }

    /**
     * This is an utility method to fetch the account for the given account number
     *
     * @param accountNumber
     * @return
     */
    private Account getAccount(Integer accountNumber) {
        List<Account> accounts = MockData.getAccounts();
        Account providedAccount = accounts.stream().filter(account -> accountNumber.equals(account.getAccountNumber())).findAny().orElse(null);
        return providedAccount;
    }

    /**
     * This method handles the operation to transfer funds from one account to beneficiary account
     *
     * @param transferRequest
     * @return
     */
    @Override
    public TransferResponse transferFunds(TransferRequest transferRequest) {
        TransferResponse transferResponse = new TransferResponse();
        try {
            Account providedAccount = getAccount(transferRequest.getAccountNumber());
            Account beneficiaryAccount = getAccount(transferRequest.getBeneficiaryAccountNumber());
            if(providedAccount == null) {
                log.info(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
                transferResponse.setStatus(BankingApiConstants.MSG_FAILURE);
                transferResponse.setMessage(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
                return transferResponse;
            } else if(beneficiaryAccount == null) {
                log.info(BankingApiConstants.MSG_BNF_ACCOUNT_NOT_FOUND);
                transferResponse.setStatus(BankingApiConstants.MSG_FAILURE);
                transferResponse.setMessage(BankingApiConstants.MSG_BNF_ACCOUNT_NOT_FOUND);
                return transferResponse;
            } else if(providedAccount.getBalance().compareTo(transferRequest.getAmount()) == -1) {
                log.info(BankingApiConstants.MSG_INSUFFICIENT_FUNDS);
                transferResponse.setStatus(BankingApiConstants.MSG_FAILURE);
                transferResponse.setMessage(BankingApiConstants.MSG_INSUFFICIENT_FUNDS);
                return transferResponse;
            }
            Transaction transaction = withdrawFunds(transferRequest.getAccountNumber(), transferRequest.getAmount());
            transaction = depositFunds(transferRequest.getBeneficiaryAccountNumber(), transferRequest.getAmount());
            transferResponse.setStatus(transaction.getTransactionStatus());
            transferResponse.setMessage(transaction.getTransactionStatus());
        } catch (Exception e) {
            log.error(e.getMessage());
            transferResponse.setStatus(BankingApiConstants.MSG_FAILURE);
            transferResponse.setMessage(e.getMessage());
        }
        return transferResponse;
    }

    /**
     * This method handles the operation to update account type
     *
     * @param accountTypeRequest
     * @return
     */
    @Override
    public AccountTypeResponse updateAccountType(AccountTypeRequest accountTypeRequest) {
        AccountTypeResponse accountTypeResponse = new AccountTypeResponse();
        try {
            Account account = getAccount(accountTypeRequest.getAccountNumber());
            if(account == null) {
                accountTypeResponse.setStatus(BankingApiConstants.MSG_FAILURE);
                accountTypeResponse.setMessage(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
                return accountTypeResponse;
            } else if(accountTypeRequest.getAccountType().equals(account.getAccountType())) {
                accountTypeResponse.setStatus(BankingApiConstants.MSG_FAILURE);
                accountTypeResponse.setMessage(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
                return accountTypeResponse;
            }
            account.setAccountType(accountTypeRequest.getAccountType());
            accountTypeResponse.setStatus(BankingApiConstants.MSG_SUCCESS);
            accountTypeResponse.setMessage(BankingApiConstants.MSG_ACCOUNT_UPDATE_SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage());
            accountTypeResponse.setStatus(BankingApiConstants.MSG_FAILURE);
            accountTypeResponse.setMessage(e.getMessage());
        }
        return accountTypeResponse;
    }

    /**
     * This method handles the operation to withdraw funds from given account
     *
     * @param withdrawlRequest
     * @return
     */
    @Override
    public WithdrawlResponse withdrawFunds(WithdrawlRequest withdrawlRequest) {
        WithdrawlResponse withdrawlResponse = new WithdrawlResponse();
        try {
            Transaction transaction = withdrawFunds(withdrawlRequest.getAccountNumber(), withdrawlRequest.getAmount());
            withdrawlResponse.setTransactionId(transaction.getTransactionId());
            withdrawlResponse.setStatus(transaction.getTransactionStatus());
            withdrawlResponse.setMessage(transaction.getTransactionStatus());
        } catch (Exception e) {
            log.error(e.getMessage());
            withdrawlResponse.setStatus(BankingApiConstants.MSG_FAILURE);
            withdrawlResponse.setMessage(e.getMessage());
        }
        return withdrawlResponse;
    }

    /**
     * This is an utility method to withdraw funds from an account
     *
     * @param accountNumber
     * @param amount
     * @return
     */
    private Transaction withdrawFunds(Integer accountNumber, BigDecimal amount) {
        Account providedAccount = getAccount(accountNumber);
        Transaction transaction = new Transaction();
        if(providedAccount == null) {
            log.error(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
            transaction.setTransactionStatus(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
        } else if(providedAccount.getBalance().compareTo(amount) == -1) {
            log.error(BankingApiConstants.MSG_ACCOUNT_NOT_FOUND);
            transaction.setTransactionStatus(BankingApiConstants.MSG_INSUFFICIENT_FUNDS);
        }
        providedAccount.setBalance(providedAccount.getBalance().subtract(amount));
        List<Transaction> transactions = getTransactions(accountNumber);
        transaction = new Transaction(transactions.size()+1, "deposit", BankingApiConstants.MSG_SUCCESS, "", "CR", amount);
        transactions.add(transaction);
        return transaction;
    }
}
