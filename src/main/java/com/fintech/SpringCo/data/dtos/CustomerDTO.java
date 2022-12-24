package com.fintech.SpringCo.data.dtos;
import com.fintech.SpringCo.data.models.Account;

public class CustomerDTO {
	
	private Long id;
	private String name;
	private String email;
	private Account account;
	
	public CustomerDTO(Long id, String name, String email, Account account) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.account = account;
	}
	public CustomerDTO() {
		super();
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
	public Account getAccount(){
		return account;
	}
	

}
