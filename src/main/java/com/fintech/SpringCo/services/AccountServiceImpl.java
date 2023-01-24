package com.fintech.SpringCo.services;


import com.fintech.SpringCo.data.dtos.*;
import com.fintech.SpringCo.data.models.*;
import com.fintech.SpringCo.data.repositories.AccountOperationRepository;
import com.fintech.SpringCo.data.repositories.AccountRepository;
import com.fintech.SpringCo.data.repositories.CustomerRepository;
import com.fintech.SpringCo.mappers.AccountMapperImpl;
import com.fintech.SpringCo.web.exception.AccountNotFoundException;
import com.fintech.SpringCo.web.exception.BalanceNotSufficientException;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountOperationRepository accountOperationRepository;

    @Autowired
    private AccountMapperImpl dtoMapper;

    @Autowired
    private CustomerService customerService;



    @Override
    public AccountDTO getAccount(String accountId) throws AccountNotFoundException {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (account instanceof Flex) {
            Flex flex = (Flex) account;
            return dtoMapper.fromFlex(flex);
        } else if (account instanceof Deluxe) {
            Deluxe deluxe = (Deluxe) account;
            return dtoMapper.fromDeluxe(deluxe);
        } else if (account instanceof Piggy ) {
            Piggy piggy = (Piggy) account;
            return dtoMapper.fromPiggy(piggy);
        } else if (account instanceof Supa ) {
            Supa supa = (Supa) account;
            return dtoMapper.fromSupa(supa);
        } else {
            Viva viva = (Viva) account;
            return dtoMapper.fromViva(viva);
        }
    }

    @Override
    public void debit(String accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if (account.getBalance() < amount) {
            throw new BalanceNotSufficientException("Balance not sufficient");
        }

        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setOperationDate(new Date());
        accountOperation.setAccount(account);
        accountOperationRepository.save(accountOperation);

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

         log.info(" Saved Account  :: {}", account);

    }


    @Override
    public void credit(String accountId, double amount, String description) throws AccountNotFoundException {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationType.CREDIT);
        accountOperation.setAmount(amount);
        accountOperation.setOperationDate(new Date());
        accountOperation.setAccount(account);
        accountOperationRepository.save(accountOperation);

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }


    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {

        debit(accountIdSource, amount, "Transfer to " + accountIdDestination);
        credit(accountIdDestination, amount, "Transfer from " + accountIdSource);
    }


    @Override
    public FlexDTO saveFlexAccount(double initialBalance,  Long customerId)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if(customer==null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        Flex flex = new Flex();
        flex.setId(UUID.randomUUID().toString());
        flex.setCreatedAt(new Date());
        flex.setBalance(initialBalance);
       // flex.setInterestRate(interestRate);
        Flex savedFlex = accountRepository.save(flex);
        return dtoMapper.fromFlex(savedFlex);
    }


    @Override
    public Deluxe saveDeluxeAccount(double initialBalance,  Long customerId)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        Deluxe deluxe = new Deluxe();
        deluxe.setId(UUID.randomUUID().toString());
        deluxe.setCreatedAt(new Date());
        deluxe.setBalance(initialBalance);
        deluxe.setCustomer(customer);
       // deluxe.setInterestRate(interestRate);
        Deluxe savedDeluxe = accountRepository.save(deluxe);
        return savedDeluxe;
    }


    @Override
    public PiggyDTO savePiggyAccount(double initialBalance, Long customerId)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        Piggy piggy = new Piggy();
        piggy.setId(UUID.randomUUID().toString());
        piggy.setCreatedAt(new Date());
        piggy.setBalance(initialBalance);
        piggy.setCustomer(customer);
      //  piggy.setInterestRate(interestRate);
        Piggy savedPiggy = accountRepository.save(piggy);
        return dtoMapper.fromPiggy(savedPiggy);
    }


    @Override
    public SupaDTO saveSupaAccount(double initialBalance, Long customerId)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        Supa supa = new Supa();
        supa.setId(UUID.randomUUID().toString());
        supa.setCreatedAt(new Date());
        supa.setBalance(initialBalance);
        supa.setCustomer(customer);
        Supa savedSupa = accountRepository.save(supa);

        return dtoMapper.fromSupa(savedSupa);
    }


    @Override
    public VivaDTO saveVivaAccount(double initialBalance, Long customerId)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        Viva viva = new Viva();
        viva.setId(UUID.randomUUID().toString());
        viva.setCreatedAt(new Date());
        viva.setBalance(initialBalance);
        viva.setCustomer(customer);
//        viva.setInterestRate(interestRate);
        Viva savedViva = accountRepository.save(viva);
        return dtoMapper.fromViva(savedViva);
    }


    @Override
    public List<AccountDTO> listAccount() {

        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(account -> {
            if (account instanceof Flex) {
                Flex flex = (Flex) account;
                return dtoMapper.fromFlex(flex);
            } else if (account instanceof Deluxe) {
                Deluxe deluxe = (Deluxe) account;
                return dtoMapper.fromDeluxe(deluxe);
            } else if (account instanceof Piggy) {
                Piggy piggy = (Piggy) account;
                return dtoMapper.fromPiggy(piggy);
            } else if (account instanceof Supa) {
                Supa supa = (Supa) account;
                return dtoMapper.fromSupa(supa);
            } else {
                Viva viva = (Viva) account;
                return dtoMapper.fromViva(viva);
            }
        }).collect(Collectors.toList());
    }


    @Override
    public double getTheInterestWithMinBalancePerYears(int numberOfYears, String accountId) throws AccountNotFoundException, BalanceNotSufficientException {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        while (account.getBalance() >= 20000.0) {
            if (account instanceof Flex) {
                double interest = account.getBalance() * numberOfYears * 2.5;
                double balance = account.getBalance() + interest;
                return interest;
            } else if (account instanceof Deluxe) {
                double interest = account.getBalance() * numberOfYears * 3.5;
                double balance = account.getBalance() + interest;
                return interest;
            } else if (account instanceof Viva) {
                double interest = account.getBalance() * numberOfYears * 6.0;
                double balance = account.getBalance() + interest;
                return interest;
            } else if (account instanceof Piggy) {
                double interest = account.getBalance() * numberOfYears * 9.2;
                double balance = account.getBalance() + interest;
                return interest;
            } else if (account instanceof Supa) {
                double interest = account.getBalance() * numberOfYears * 10.0;
                double balance = account.getBalance() + interest;
                return interest;
            }
        }
        return 0;
    }


    @Override
    public List<Customer> filterAllCustomersWithASpecificAccountType(String type) throws AccountNotFoundException {


        List<Customer> customers = customerRepository.findByAccountsContaining(type);

        return customers;
    }


    @Override
    public List<Account> filterAllAccountsForASpecificCustomer(String customerName) {
        List<Account> accounts = accountRepository.findAll();
        List<Account> filteredAccounts = Collections.singletonList(new Account());
        for (Account account : accounts) {
            if (accounts.contains(customerName)) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }


    @Override
    public List<Account> filterAllAccountsWithoutCustomer() {
        List<Account> filteredAccounts = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {
            if (customerService.listCustomers().isEmpty()) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }


    @Override
    public List<CustomerDTO> filterAllCustomersWithZeroBalance() {
        List<CustomerDTO> filteredCustomersList = new ArrayList<>();
        for (CustomerDTO customer : customerService.listCustomers()) {
           // if (customer.getAccount().getBalance() == 0.0) filteredCustomersList.add(customer);
        }
        return filteredCustomersList;
    }
}


