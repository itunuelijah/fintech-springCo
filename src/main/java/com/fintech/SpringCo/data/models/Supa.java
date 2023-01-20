package com.fintech.SpringCo.data.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("S")
public class Supa extends Account {

    private double interestRate;

    public Supa(String id, Date createdAt, Customer customer,
                List<AccountOperation> accountOperations, double interestRate) {
        super(id,  createdAt, customer, accountOperations);
        this.interestRate = interestRate;
    }
    public Supa() {
        super();
    }

    public Supa(String id, double balance, Date createdAt, Customer customer,
                List<AccountOperation> accountOperations) {
        super(id, createdAt, customer, accountOperations);
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
