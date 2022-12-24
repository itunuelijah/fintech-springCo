package com.fintech.SpringCo.data.dtos;

import java.util.Date;

public class DeluxeDTO extends AccountDTO {
	
	private String id;
	private double balance;
	private Date createdAt;
	private CustomerDTO customerDTO;
	private double interestRate;
	
	
	public DeluxeDTO() {
		super();
	}
	public DeluxeDTO(String id, Date createdAt,
					 CustomerDTO customerDTO) {
	
		this.id = id;
		this.balance = 0.0;
		this.createdAt = createdAt;
		this.customerDTO = customerDTO;
		this.interestRate = interestRate;
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

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	

}
