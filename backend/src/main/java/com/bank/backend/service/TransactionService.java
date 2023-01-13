package com.bank.backend.service;



import java.util.List;

import com.bank.backend.entity.Account;
import com.bank.backend.entity.Transaction;


public interface TransactionService {

	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getallTransaction();
	public Transaction updateTransaction(Transaction transaction);
	Transaction findByAccountNumber(String accountNumber);
	List<Transaction> findByidAccount (Account idAccount);
	public boolean deleteTransactionById(int id);
	
}
