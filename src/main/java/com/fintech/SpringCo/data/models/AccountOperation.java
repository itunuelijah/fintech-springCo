package com.fintech.SpringCo.data.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AccountOperation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date operationDate;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private OperationType type;
	@ManyToOne
	private Account account;
	
	private String description;

	public AccountOperation(Long id, Date operationDate, double amount, OperationType type, Account account,
			String description) {
		this.id = id;
		this.operationDate = operationDate;
		this.amount = amount;
		this.type = type;
		this.account = account;
		this.description = description;
	}

	public AccountOperation() {
		//empty
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
