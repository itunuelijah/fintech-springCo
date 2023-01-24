package com.fintech.SpringCo.services;


import com.fintech.SpringCo.data.dtos.CustomerDTO;

import com.fintech.SpringCo.data.models.Customer;


import com.fintech.SpringCo.data.repositories.CustomerRepository;
import com.fintech.SpringCo.mappers.AccountMapperImpl;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private  AccountMapperImpl dtoMapper;

    @Autowired
    private  AccountServiceImpl accountService;



    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        log.info("saving new customer");
        Customer customer = dtoMapper.fromCustomerDTO(customerDTO);
//        Customer customer = new Customer();
//        customer.setEmail(customerDTO.getEmail());
//        customer.setName(customerDTO.getName());
//        customer.setAccounts((List<Account>) customerDTO.getAccount());
        Customer savedCustomer  = customerRepository.save(customer);
        log.info(" Saved Customer  :: {}", customer);
        return dtoMapper.fromCustomer(savedCustomer);
    }




    @Override
    public List<CustomerDTO> listCustomers() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> list = new ArrayList<>();
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
