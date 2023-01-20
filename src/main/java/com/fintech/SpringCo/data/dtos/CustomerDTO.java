package com.fintech.SpringCo.data.dtos;
import com.fintech.SpringCo.data.models.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
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
	public CustomerDTO(long id, String ade, String email, AccountDTO account) {
		super();
	}

    public CustomerDTO(long l, String ade, String s) {

    }



}
