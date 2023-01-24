package com.fintech.SpringCo.data.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
        this.email = email;
        this.accounts = Collections.singletonList(account);
    }


}

