package com.bank.service;

import java.util.List;

import com.bank.entity.Client;


public interface ClientService {
	
	public Client createClient(Client client);
	public List<Client> getallClients();
	public Client updateClient(int id, Client client);
	public boolean deleteClientById(int id);


}
