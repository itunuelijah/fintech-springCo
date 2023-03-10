package com.fintech.SpringCo.data.models;


import jakarta.persistence.*;


import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4, discriminatorType = DiscriminatorType.STRING)
public class Account {

    @Id
    private String id;
    private double balance;
    private Date createdAt;


    @Column(insertable=false, updatable=false)
    private String type;


    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;


    public Account(String id, Date createdAt, Customer customer,
                       List<AccountOperation> accountOperations) {
        super();
        this.id = id;
        this.balance = 0.0;
        this.createdAt = createdAt;
        this.customer = customer;
        this.accountOperations = accountOperations;
    }

    public Account() {
        super();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }
    public void setAccountOperations(List<AccountOperation> accountOperations) {
        this.accountOperations = accountOperations;
    }
    public String getType() {
        return type;
    }

}



