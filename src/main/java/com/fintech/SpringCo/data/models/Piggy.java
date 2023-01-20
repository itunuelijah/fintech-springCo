package com.fintech.SpringCo.data.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("P")
public class Piggy extends Account {

    private double interestRate;

    public Piggy(String id, Date createdAt, Customer customer,
                 List<AccountOperation> accountOperations, double interestRate) {
        super(id, createdAt, customer, accountOperations);
        this.interestRate = interestRate;
    }
    public Piggy() {
        super();
    }

    public Piggy(String id,  Date createdAt, Customer customer,
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
