package com.fintech.SpringCo.data.repositories;

import com.fintech.SpringCo.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.name like :kw")
    List<Customer> findByNameContains(@Param("kw") String keywords);
    List<Customer> findByAccountsContaining(String type);

}
