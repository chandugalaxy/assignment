package com.suncorp.banking.dao;

import com.suncorp.banking.model.*;

import java.util.List;

/**
 * This is the interface for the Repository which defines the methods to handle data layer part of the API operations
 *
 * @author Chandra
 * @version 1.0
 */
public interface BankingDAO {

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);

    DepositResponse depositFunds(DepositRequest depositRequest);

    List<Transaction> getTransactions(Integer accountNumber);

    TransferResponse transferFunds(TransferRequest transferRequest);

    AccountTypeResponse updateAccountType(AccountTypeRequest accountTypeRequest);

    WithdrawlResponse withdrawFunds(WithdrawlRequest withdrawlRequest);
}
