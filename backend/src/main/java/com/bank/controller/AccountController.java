package com.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Account;
import com.bank.service.AccountService;



@RestController
@RequestMapping("/accounts")

public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping
    public ResponseEntity<List<Account>> getAccount(){
		return new ResponseEntity<>(accountService.getallAccounts(), HttpStatus.OK);
	}
	
	
    @PostMapping("create/{clientId}")
    public ResponseEntity<Account> createAccount(@PathVariable int clientId, @RequestBody Account account){

        if (accountService.createAccount(clientId, account) != null){
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
	
	@PutMapping("update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int idAccount, @RequestBody Account account){
		
        if (accountService.updateAccount(idAccount, account) != null){
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	
	}
	
	@GetMapping("/getByClientId/{idClient}")
    public ResponseEntity<List<Account>> getByidClient(@PathVariable("idClient") Client idClient ){
		
		List<Account> accountByid = accountService.findByidClient(idClient);
		
		
		if (accountByid.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Account>>(accountService.findByidClient(idClient), HttpStatus.OK);
		
	}
	
        
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAccountById(@PathVariable("id") int idAccount){
    	
        if (accountService.deleteAccountById(idAccount)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
}
    
}
