package com.fintech.SpringCo.web.controllers;


import com.fintech.SpringCo.data.dtos.*;
import com.fintech.SpringCo.data.models.*;
import com.fintech.SpringCo.services.AccountServiceImpl;

import com.fintech.SpringCo.services.CustomerServiceImpl;
import com.fintech.SpringCo.web.exception.AccountNotFoundException;
import com.fintech.SpringCo.web.exception.BalanceNotSufficientException;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountRestController {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private CustomerServiceImpl customerService;



    @GetMapping("/{accountId}")
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




    @PostMapping("/saveFlex")
    @ResponseBody
    public FlexDTO saveFlexAccount(@RequestBody FlexDTO flexDTO) throws CustomerNotFoundException {

        return accountService.saveFlexAccount(flexDTO.getBalance(), flexDTO.getCustomerDTO().getId());
    }



    @PostMapping("/saveDeluxe")
    @ResponseBody
    public Deluxe saveDeluxeAccount(@RequestBody DeluxeDTO deluxeDTO) throws CustomerNotFoundException {

        return accountService.saveDeluxeAccount(deluxeDTO.getBalance(), deluxeDTO.getCustomerDTO().getId());
    }



    @PostMapping("/savePiggy")
    @ResponseBody
    public PiggyDTO savePiggyAccount(@RequestBody PiggyDTO piggyDTO) throws  CustomerNotFoundException{

       return accountService.savePiggyAccount(piggyDTO.getBalance(), piggyDTO.getCustomerDTO().getId());
    }



    @PostMapping("/saveSupa")
    @ResponseBody
    public SupaDTO saveSupaAccount(@RequestBody SupaDTO supaDTO) throws CustomerNotFoundException {

        return accountService.saveSupaAccount(supaDTO.getBalance(), supaDTO.getCustomerDTO().getId());
    }



    @PostMapping("/saveViva")
    @ResponseBody
    public VivaDTO saveVivaAccount(@RequestBody VivaDTO vivaDTO) throws CustomerNotFoundException {

        return accountService.saveVivaAccount(vivaDTO.getBalance(), vivaDTO.getCustomerDTO().getId());
    }

    @GetMapping("/get/{accountType}")
    public List<Customer> filterAllCustomersWithASpecificAccountType(String accountType) throws AccountNotFoundException {
        return accountService.filterAllCustomersWithASpecificAccountType(accountType);

    }

    @GetMapping("/{customerName} ")
    public List<Account> filterAllAccountsForASpecificCustomer(String customerName) {
        return accountService.filterAllAccountsForASpecificCustomer(customerName);
    }


    @GetMapping("/get/noCustomer")
    public List<Account> filterAllAccountsWithoutCustomer() {
        return accountService.filterAllAccountsWithoutCustomer();
    }


    @GetMapping("/get/zeroBalance")
    public List<CustomerDTO> filterAllCustomersWithZeroBalance() {
        return accountService.filterAllCustomersWithZeroBalance();
    }

    @GetMapping("/duration/{duration}")
    public double getInterestPerYears(@PathVariable Integer duration, String accountId) throws AccountNotFoundException {
        try {
            return accountService.getTheInterestWithMinBalancePerYears(duration, accountId);
        } catch (BalanceNotSufficientException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
