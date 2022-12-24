package com.fintech.SpringCo.services;

import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.data.models.Customer;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    CustomerDTO registerCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> listCustomers();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<CustomerDTO> searchCustomers(String keyword);

}
