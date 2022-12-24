package com.fintech.SpringCo.data.models;

import com.fintech.SpringCo.data.dtos.AccountDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public Customer(long id, String name, String email, Account account) {
        this.id = id;
        this.name =name;
        this.accounts = Collections.singletonList(account);
    }

    public Customer() {
    }

    public Account getAccount() {
        return (Account) accounts;
    }

    public void addAccount(Account account){
        if(account == null){
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

