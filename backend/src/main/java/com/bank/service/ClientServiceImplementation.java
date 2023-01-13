package com.bank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.Client;
import com.bank.repository.AccountRepository;
import com.bank.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service

public class ClientServiceImplementation implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		
		AgeCalculator ageCalculator = new AgeCalculator();
		int age = ageCalculator.calculateAge(client.getBirthDate(), LocalDate.now());
		 if (age>=18) {
	            client.setCreationDate(LocalDate.now());
	            client.setUserCreation("admin");
	            client.setUserModification("admin");
	            return clientRepository.save(client);
	        } 
	        return null;
		
	}

	@Override
	public List<Client> getallClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(int idClient, Client client) {
		// TODO Auto-generated method stub
		
		Client existingClient = clientRepository.findById(idClient).get();
		
		if (client.getIdentificationType() != null) {
			existingClient.setIdentificationType(client.getIdentificationType());

		} 
		
		if (client.getIdentificationNumber() != null) {
			existingClient.setIdentificationNumber(client.getIdentificationNumber());

		} 
		
		if (client.getName() != null) {
			existingClient.setName(client.getName());

		} 
	
		if (client.getLastName() != null) {
			existingClient.setLastName(client.getLastName());

		}
		
		if (client.getEmail() != null) {
			existingClient.setEmail(client.getEmail());
			
		}	
			
		if (client.getBirthDate() != null) {
			existingClient.setBirthDate(client.getBirthDate());
			
		}	
		
		if (client.getBirthDate() != null) {
			existingClient.setBirthDate(client.getBirthDate());
			
		}	
	
		existingClient.setModificationDate(LocalDate.now());
		
		return clientRepository.save(existingClient);
	}
	
	
	@Override
	public boolean deleteClientById(int idClient) {
		// TODO Auto-generated method stub
			
		Client client = clientRepository.findById(idClient).orElseThrow(() -> new EntityNotFoundException("Client not found"));
		
		List <Account> allAccountsById =  accountRepository.findAllByidClient(client);
		
		List <Account> cancelledAccount = allAccountsById.stream().filter((p) -> p.getAccountStatus().equalsIgnoreCase("cancelled")).collect(Collectors.toList());
		
		if (allAccountsById.size() != cancelledAccount.size()) {
			System.out.println("not all accounts are cancelled");
			return false;
		}
		
		client.setDeleteid(true);
		
		clientRepository.save(client);
		return true;
		
	}


	

}
