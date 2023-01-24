package com.fintech.SpringCo.data.repositories;


import com.fintech.SpringCo.data.dtos.AccountDTO;
import com.fintech.SpringCo.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<AccountDTO> findByType(String type);
}
