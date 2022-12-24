package com.fintech.SpringCo.mappers;

import com.fintech.SpringCo.data.dtos.*;
import com.fintech.SpringCo.data.models.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountMapperImpl {
	
	public CustomerDTO fromCustomer(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
	}
	
	public Customer fromCustomerDTO(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		return customer;
	}

	public DeluxeDTO fromDeluxe(Deluxe deluxe) {
		DeluxeDTO deluxeDTO = new DeluxeDTO();
		BeanUtils.copyProperties(deluxe, deluxeDTO);
		deluxeDTO.setCustomerDTO(fromCustomer(deluxe.getCustomer()));
		deluxeDTO.setType(deluxe.getClass().getSimpleName());
		return deluxeDTO;

	}

	public Deluxe fromDeluxeDTO(DeluxeDTO deluxeDTO) {
		Deluxe deluxe = new Deluxe();
		BeanUtils.copyProperties(deluxeDTO, deluxe);
		deluxe.setCustomer(fromCustomerDTO(deluxeDTO.getCustomerDTO()));
		return null;

	}


	public FlexDTO fromFlex(Flex flex) {
		FlexDTO flexDTO = new FlexDTO();
		BeanUtils.copyProperties(flex, flexDTO);
		flexDTO.setCustomerDTO(fromCustomer(flex.getCustomer()));
		flexDTO.setType(flex.getClass().getSimpleName());
		return flexDTO;

	}
	public Flex fromFlexDTO(FlexDTO flexDTO) {
		Flex flex = new Flex();
		BeanUtils.copyProperties(flexDTO, flex);
		flex.setCustomer(fromCustomerDTO(flexDTO.getCustomerDTO()));
		return null;

	}

	public PiggyDTO fromPiggy(Piggy piggy) {
		PiggyDTO piggyDTO = new PiggyDTO();
		BeanUtils.copyProperties(piggy, piggyDTO);
		piggyDTO.setCustomerDTO(fromCustomer(piggy.getCustomer()));
		piggyDTO.setType(piggy.getClass().getSimpleName());
		return piggyDTO;
	}

	public Piggy fromPiggyDTO(PiggyDTO piggyDTO) {
		Piggy piggy = new Piggy();
		BeanUtils.copyProperties(piggyDTO, piggy);
		piggy.setCustomer(fromCustomerDTO(piggyDTO.getCustomerDTO()));
		return null;

	}




	public SupaDTO fromSupa(Supa supa) {
		SupaDTO supaDTO = new SupaDTO();
		BeanUtils.copyProperties(supa, supaDTO);
		supaDTO.setCustomerDTO(fromCustomer(supa.getCustomer()));
		supaDTO.setType(supa.getClass().getSimpleName());
		return supaDTO;
	}

	public Supa fromSupaDto(SupaDTO supaDTO) {
		Supa supa = new Supa();
		BeanUtils.copyProperties(supaDTO, supa);
		supa.setCustomer(fromCustomerDTO(supaDTO.getCustomerDTO()));
		return null;
	}

	public VivaDTO fromViva(Viva viva) {
		VivaDTO vivaDTO = new VivaDTO();
		BeanUtils.copyProperties(viva, vivaDTO);
		vivaDTO.setCustomerDTO(fromCustomer(viva.getCustomer()));
		vivaDTO.setType(viva.getClass().getSimpleName());
		return vivaDTO;
	}

	public Viva fromVivaDto(VivaDTO vivaDTO) {
		Viva viva = new Viva();
		BeanUtils.copyProperties(vivaDTO, viva);
		viva.setCustomer(fromCustomerDTO(vivaDTO.getCustomerDTO()));
		return null;
	}

	public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation) {
		AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
		BeanUtils.copyProperties(accountOperation, accountOperationDTO);
		return accountOperationDTO;
	}


}
