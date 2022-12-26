package com.fintech.SpringCo.web.controllers;


import com.fintech.SpringCo.data.dtos.AccountDTO;
import com.fintech.SpringCo.data.dtos.CreditDTO;
import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.data.dtos.DebitDTO;
import com.fintech.SpringCo.data.models.Account;
import com.fintech.SpringCo.data.models.Customer;
import com.fintech.SpringCo.services.AccountServiceImpl;
import com.fintech.SpringCo.services.CustomerService;
import com.fintech.SpringCo.services.CustomerServiceImpl;
import com.fintech.SpringCo.web.exception.AccountNotFoundException;
import com.fintech.SpringCo.web.exception.BalanceNotSufficientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountRestController {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private CustomerServiceImpl customerService;



    @GetMapping("/get/{accountId}")
    public AccountDTO getAccount(@PathVariable String accountId) throws AccountNotFoundException {
        return accountService.getAccount(accountId);
    }

    @GetMapping("/list")
    public List<AccountDTO> listAccount() {
        return accountService.listAccount();
    }


    @PostMapping("/debit")
    @ResponseBody
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws AccountNotFoundException, BalanceNotSufficientException {
        accountService.debit(debitDTO.getAccountId(),debitDTO.getAmount(), debitDTO.getDescription());
        return debitDTO;
    }

    @PostMapping("/credit")
    @ResponseBody
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws AccountNotFoundException {
        accountService.credit(creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription());
        return creditDTO;
    }

    @GetMapping("/get/{duration}")
    public double getInterestPerYears(@PathVariable int duration, String accountId) throws AccountNotFoundException {
        try {
            return accountService.getTheInterestWithMinBalancePerYears(duration, accountId);
        } catch (BalanceNotSufficientException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @GetMapping("/get/{accountType}")
    public List<Customer> filterAllCustomersWithASpecificAccountType(String accountType) {
      return accountService.filterAllCustomersWithASpecificAccountType(accountType);

    }


    @GetMapping("/get/{specificCustomer} ")
    public List<AccountDTO> filterAllAccountsForASpecificCustomer(String customerName) {
       return  accountService.filterAllAccountsForASpecificCustomer(customerName);
    }


    @GetMapping("/get/noCustomer")
    public List<Account> filterAllAccountsWithoutCustomer() {
      return accountService.filterAllAccountsWithoutCustomer();
    }


    @GetMapping("/get/zeroBalance")
    public List<CustomerDTO> filterAllCustomersWithZeroBalance() {
     return  accountService.filterAllCustomersWithZeroBalance();
}

}
