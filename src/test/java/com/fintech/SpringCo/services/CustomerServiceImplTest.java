package com.fintech.SpringCo.services;

import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.mappers.AccountMapperImpl;
import com.fintech.SpringCo.web.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Slf4j
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountMapperImpl accountMapper;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerCustomer() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(5676L);
        customerDTO.setName("Ade");
        customerDTO.setEmail("ade@gmail.com");

        CustomerDTO customer = customerService.registerCustomer(customerDTO);
        log.info("Customer created :: {}", customer);
        assertThat(customer).isNotNull();
        assertThat(customer.getName().equals("Ade"));

    }

    @Test
    void listCustomers() throws CustomerNotFoundException {

        CustomerDTO customer1 = new CustomerDTO(1l, "sam", "sam@gmail.com");
        CustomerDTO customer2 = new CustomerDTO(2l, "Jame", "james@gmail.com");
        CustomerDTO customer3 = new CustomerDTO(3l, "Paul", "paul@gmail.com");

        customerService.listCustomers().add(customer1);
        customerService.listCustomers().add(customer2);
        customerService.listCustomers().add(customer3);
        assertThat(customerService.listCustomers().size()).isNotNull();

        assertThat(customer2).isIn(customerService.listCustomers());


    }
}