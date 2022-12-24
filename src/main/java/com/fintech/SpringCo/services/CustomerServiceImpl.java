package com.fintech.SpringCo.services;


import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.data.models.Customer;

import com.fintech.SpringCo.data.repositories.AccountRepository;
import com.fintech.SpringCo.data.repositories.CustomerRepository;
import com.fintech.SpringCo.mappers.AccountMapperImpl;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private  CustomerRepository customerRepository;

    private  AccountMapperImpl dtoMapper;
    private  AccountServiceImpl accountService;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository, AccountMapperImpl dtoMapper, AccountServiceImpl accountService) {
        this.customerRepository = customerRepository;
        this.dtoMapper = dtoMapper;
        this.accountService = accountService;
    }

    public CustomerServiceImpl(){
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        log.info("saving new customer");
        Customer customer = dtoMapper.fromCustomerDTO(customerDTO);
        try {
            accountService.saveFlexAccount();
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
        Customer savedCustomer = customerRepository.save(customer);
        return dtoMapper.fromCustomer(savedCustomer);


    }


    @Override
    public List<CustomerDTO> listCustomers() {

        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> dtoMapper.fromCustomer(customer))
                .collect(Collectors.toList());
    }


    @Override
    public CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));

        return dtoMapper.fromCustomer(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        log.info("update customer");
        Customer customer = dtoMapper.fromCustomerDTO(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return dtoMapper.fromCustomer(savedCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<CustomerDTO> searchCustomers(String keyword) {
        List<Customer> customers = customerRepository.findByNameContains(keyword);
        return customers.stream()
                .map(customer -> dtoMapper.fromCustomer(customer))
                .collect(Collectors.toList());
    }
}
