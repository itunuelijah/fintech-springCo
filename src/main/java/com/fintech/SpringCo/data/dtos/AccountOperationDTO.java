package com.fintech.SpringCo.data.dtos;

import com.fintech.SpringCo.data.models.OperationType;

import java.util.Date;

public class AccountOperationDTO {
	
	private Long id;
	private Date operationDate;
	private double amount;
	private OperationType type;

	
	public AccountOperationDTO(Long id, Date operationDate, double amount, OperationType type, String description) {
		
		this.id = id;
		this.operationDate = operationDate;
		this.amount = amount;
		this.type = type;

	}
	public AccountOperationDTO() {
		super();
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

}
