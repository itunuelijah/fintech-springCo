package com.fintech.SpringCo.data.repositories;


import com.fintech.SpringCo.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
