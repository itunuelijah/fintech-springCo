package com.fintech.SpringCo.data.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("D")
public class Deluxe extends Account {


    private double interestRate;

    public Deluxe (String id, Date createdAt, Customer customer,
                 List<AccountOperation> accountOperations, double interestRate) {
        super(id, createdAt, customer, accountOperations);
        this.interestRate = interestRate;
    }

    public Deluxe () {
        super();
    }

    public Deluxe (String id, Date createdAt, Customer customer,
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