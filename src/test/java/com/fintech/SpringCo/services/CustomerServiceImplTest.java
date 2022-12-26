package com.fintech.SpringCo.services;

import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.data.models.Account;
import com.fintech.SpringCo.mappers.AccountMapperImpl;
import com.fintech.SpringCo.web.exception.AccountNotFoundException;
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

    void registerCustomer()  {

//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setId(5676l);
//        customerDTO.setName("Ade");
//        customerDTO.setEmail("ade@gmail.com");
//        CustomerDTO customer = null;
//        customer = customerService.registerCustomer(customerDTO);
//        assertThat(customer).isNotNull();
//       // assertThat(customer.getName().equals("Ade"));
//
//    }
//
//    @Test
//    void listCustomers() throws AccountNotFoundException {
//        CustomerDTO customer1 = new CustomerDTO(1l, "sam", "sam@gmail.com", accountService.getAccount("2345"));
//        CustomerDTO customer2 = new CustomerDTO(1l, "Jame", "james@gmail.com", accountService.getAccount("2345"));
//        CustomerDTO customer3 = new CustomerDTO(1l, "Paul", "paul@gmail.com", accountService.getAccount("7654"));
//
//       customerService.listCustomers().add(customer1);
//       customerService.listCustomers().add(customer2);
//       customerService.listCustomers().add(customer3);
//
//       assertThat(customerService.listCustomers().size()).isEqualTo(3);
//
//       // assertThat(customer2).isIn(customerService.listCustomers());
//      //  assertThat(3).matches((Predicate<? super Integer>) customerService.listCustomers());
//
//    }

    @Test
    void getCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void searchCustomers() {
    }
}