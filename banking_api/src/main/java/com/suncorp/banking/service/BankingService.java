package com.suncorp.banking.service;

import com.suncorp.banking.model.*;

import java.util.List;

/**
 * This is the Service interface which defines the service methods to the respective API operations
 *
 * @author Chandra
 * @version 1.0
 */
public interface BankingService {

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);

    DepositResponse depositFunds(DepositRequest depositRequest);

    List<Transaction> getTransactions(Integer accountNumber);

    TransferResponse transferFunds(TransferRequest transferRequest);

    AccountTypeResponse updateAccountType(AccountTypeRequest accountTypeRequest);

    WithdrawlResponse withdrawFunds(WithdrawlRequest withdrawlRequest);
}
