package com.fintech.SpringCo.data.repositories;


import com.fintech.SpringCo.data.models.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    List<AccountOperation> findByAccountId(String accountId);
}