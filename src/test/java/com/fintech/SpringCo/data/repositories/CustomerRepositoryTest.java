package com.fintech.SpringCo.data.repositories;

import com.fintech.SpringCo.data.dtos.CustomerDTO;
import com.fintech.SpringCo.data.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;


  CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {

        customerDTO = CustomerDTO.builder()
                .id(234l)
                .name("olusola")
                .account(customerDTO.getAccount())
                .email("olusola@gmail.com").build();
    }
    @Test
    @DisplayName("Create a new customer test")
    void registerCustomerTest(){
        //creating a user object
        Customer customer = new Customer();

        customer.setName("ade");
        customer.setEmail("ade@gmail.com");

        //save user
       customerRepository.save(customer);

        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("ade");

        log.info("App user created :: {}", customer);
    }
}
