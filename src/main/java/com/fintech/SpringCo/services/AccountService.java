package com.fintech.SpringCo.services;


import com.fintech.SpringCo.data.dtos.*;
import com.fintech.SpringCo.data.models.Account;
import com.fintech.SpringCo.data.models.Customer;
import com.fintech.SpringCo.data.models.Deluxe;
import com.fintech.SpringCo.web.exception.AccountNotFoundException;
import com.fintech.SpringCo.web.exception.BalanceNotSufficientException;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;

import java.util.List;

public interface AccountService {

    Account getAccount(String accountId) throws AccountNotFoundException;

    void debit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException, BalanceNotSufficientException;

    void credit(String accountId, double amount, String description) throws AccountNotFoundException;


    void transfer(String accountIdSource, String accountIdDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException;



    Account saveFlexAccount()
            throws CustomerNotFoundException;

    Deluxe saveDeluxeAccount(double initialBalance, double interestRate, Long customerId)
            throws CustomerNotFoundException;

    PiggyDTO savePiggyAccount(double initialBalance, double interestRate, Long customerId)
            throws CustomerNotFoundException;

    SupaDTO saveSupaAccount(double initialBalance, double interestRate, Long customerId)
            throws CustomerNotFoundException;

    VivaDTO saveVivaAccount(double initialBalance, double interestRate, Long customerId)
            throws CustomerNotFoundException;

    List<AccountDTO> listAccount();
    double getTheInterestWithMinBalancePerYears(int numberOfYears, String accountId) throws AccountNotFoundException, BalanceNotSufficientException;

    List<Customer> filterAllCustomersWithASpecificAccountType(String accountType);

    List<AccountDTO> filterAllAccountsForASpecificCustomer(String name);

    List<Account> filterAllAccountsWithoutCustomer();

    List<CustomerDTO> filterAllCustomersWithZeroBalance();

}
