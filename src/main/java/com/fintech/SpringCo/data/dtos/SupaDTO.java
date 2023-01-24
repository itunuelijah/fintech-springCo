package com.fintech.SpringCo.data.dtos;



public class SupaDTO extends AccountDTO {

	private String id;
	private double balance;
	private CustomerDTO customerDTO;
	private double interestRate;


	public SupaDTO() {
		super();
	}
	public SupaDTO(String id, CustomerDTO customerDTO) {
	
		this.id = id;
		this.balance = 0.0;
		this.customerDTO = customerDTO;

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
