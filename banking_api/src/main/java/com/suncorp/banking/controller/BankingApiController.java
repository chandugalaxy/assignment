package com.suncorp.banking.controller;

import com.suncorp.banking.model.*;
import com.suncorp.banking.model.Error;
import com.suncorp.banking.service.BankingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the main Controller to handle API calls for the basic operations of Banking
 *
 * @author Chandra
 * @version 1.0
 */
@RestController
@RequestMapping("/banking")
public class BankingApiController {

    private static final Logger log = LoggerFactory.getLogger(BankingApiController.class);

    @Autowired
    BankingService bankingService;


    /**
     * This method creates new account for the given customer
     *
     * @param createAccountRequest
     * @return createAccountResponse
     */
    @ApiOperation(value = "creates a new account", nickname = "createAccount", notes = "new account will be created for the given customer and returns the created account", response = CreateAccountResponse.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = CreateAccountResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @PostMapping("/accounts")
    @ResponseBody
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return bankingService.createAccount(createAccountRequest);
    }

    /**
     * This method deposits the provided funds in to the given account
     *
     * @param depositRequest
     * @return depositResponse
     */
    @ApiOperation(value = "deposit of funds", nickname = "depositFunds", notes = "funds will be deposited in to the provided account", response = DepositResponse.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = DepositResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/banking/deposit",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    @ResponseBody
    public DepositResponse depositFunds(@RequestBody DepositRequest depositRequest) {

        return bankingService.depositFunds(depositRequest);
    }

    /**
     * This method returns the list of transactions for the given account number
     *
     * @param accountNumber
     * @return list of Transaction
     */
    @ApiOperation(value = "list of transactions", nickname = "getTransactions", notes = "returns the list of transactions for the given account", response = Transaction.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = Transaction.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/banking/transactions",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> getTransactions(@RequestParam Integer accountNumber) {

        return bankingService.getTransactions(accountNumber);
    }

    /**
     * This method transfers funds from the given account to given beneficiary account
     *
     * @param transferRequest
     * @return transferResponse
     */
    @ApiOperation(value = "transfer of funds", nickname = "transferFunds", notes = "funds will be transfered from the provided account to beneficiary account", response = TransferResponse.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = TransferResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/banking/transfer",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    @ResponseBody
    public TransferResponse transferFunds(@RequestBody TransferRequest transferRequest) {

        return bankingService.transferFunds(transferRequest);
    }

    /**
     * This method updates the account type of the given account
     *
     * @param accountTypeRequest
     * @return accountTypeResponse
     */
    @ApiOperation(value = "change of account type", nickname = "updateAccountType", notes = "account type will be modified for the given account", response = AccountTypeResponse.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = AccountTypeResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/banking/accounttype",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    @ResponseBody
    public AccountTypeResponse updateAccountType(@RequestBody AccountTypeRequest accountTypeRequest) {

        return bankingService.updateAccountType(accountTypeRequest);
    }

    /**
     * This method withdraw funds from the given account
     *
     * @param withdrawlRequest
     * @return withdrawlResponse
     */
    @ApiOperation(value = "withdrawl of funds", nickname = "withdrawFunds", notes = "funds will be withdrawn from the provided account", response = WithdrawlResponse.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = WithdrawlResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorised request", response = Error.class),
            @ApiResponse(code = 500, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/banking/withdrawl",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    @ResponseBody
    public WithdrawlResponse withdrawFunds(@RequestBody WithdrawlRequest withdrawlRequest) {

        return bankingService.withdrawFunds(withdrawlRequest);
    }
}
