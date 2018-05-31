package com.suncorp.banking.service.impl;

import com.suncorp.banking.dao.BankingDAO;
import com.suncorp.banking.model.*;
import com.suncorp.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the Service class to delegate the requests to the respective repository layer
 *
 * @author Chandra
 * @version 1.0
 */
@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    BankingDAO bankingDAO;

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        return bankingDAO.createAccount(createAccountRequest);
    }

    @Override
    public DepositResponse depositFunds(DepositRequest depositRequest) {
        return bankingDAO.depositFunds(depositRequest);
    }

    @Override
    public List<Transaction> getTransactions(Integer accountNumber) {
        return bankingDAO.getTransactions(accountNumber);
    }

    @Override
    public TransferResponse transferFunds(TransferRequest transferRequest) {
        return bankingDAO.transferFunds(transferRequest);
    }

    @Override
    public AccountTypeResponse updateAccountType(AccountTypeRequest accountTypeRequest) {
        return bankingDAO.updateAccountType(accountTypeRequest);
    }

    @Override
    public WithdrawlResponse withdrawFunds(WithdrawlRequest withdrawlRequest) {
        return bankingDAO.withdrawFunds(withdrawlRequest);
    }
}
