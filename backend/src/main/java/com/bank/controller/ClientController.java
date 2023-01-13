package com.bank.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Client;
import com.bank.service.ClientService;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping
    public ResponseEntity<List<Client>> getClients(){
		return new ResponseEntity<>(clientService.getallClients(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
		
        if (clientService.createClient(client) != null){
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    
    }
	
	@PutMapping("update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int idClient,@RequestBody Client client){
		
        if (clientService.updateClient(idClient, client) != null){
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	
	}
        
    @DeleteMapping("delete/{idClient}")
    public ResponseEntity deleteClientById(@PathVariable("idClient") int idClient){
    	
        if (clientService.deleteClientById(idClient)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            
        
    }
	

	
	

	
	

}
