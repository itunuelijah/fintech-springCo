package com.fintech.SpringCo.web.controllers;


import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.services.AccountService;
import com.fintech.SpringCo.services.CustomerService;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    @ResponseBody
    public List<CustomerDTO> customers(){
        return customerService.listCustomers();
    }

    @GetMapping("/search")
    @ResponseBody
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword){
        return customerService.searchCustomers("%"+keyword+"%");
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/save")
    @ResponseBody
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return customerService.registerCustomer(customer);
    }

    @PutMapping("/update/{customerId}")
    @ResponseBody
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(customerId);
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
