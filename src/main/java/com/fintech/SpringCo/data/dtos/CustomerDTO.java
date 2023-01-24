package com.fintech.SpringCo.data.dtos;

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

	
	public CustomerDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;

	}


}
