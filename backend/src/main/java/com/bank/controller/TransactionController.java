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

import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.service.TransactionService;


@RestController
@RequestMapping("/transactions")

public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping
    public ResponseEntity<List<Transaction>> getTransaction(){
		return new ResponseEntity<>(transactionService.getallTransaction(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
		
        if (transactionService.createTransaction(transaction) != null){
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
        
    
    }
	
	@PutMapping("update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction){
		
        if (transactionService.updateTransaction(transaction) != null){
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		
	
	}
	
	@GetMapping("/getTransactiontByIdAccount/{idAccount}")
    public ResponseEntity<List<Transaction>> getTransactiontByIdAccount(@PathVariable("idAccount") Account idAccount ){
		
		List<Transaction> transactionByid = transactionService.findByidAccount(idAccount);
		
		if (transactionByid.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Transaction>>(transactionService.findByidAccount(idAccount), HttpStatus.OK);
		
	}
	
	
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransactionById(@PathVariable("id") int idTransaction){
    	
        if (transactionService.deleteTransactionById(idTransaction)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
}
	
}
