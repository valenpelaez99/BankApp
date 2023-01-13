package com.bank.service;



import java.util.List;

import com.bank.entity.Account;
import com.bank.entity.Transaction;


public interface TransactionService {

	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getallTransaction();
	public Transaction updateTransaction(Transaction transaction);
	Transaction findByAccountNumber(String accountNumber);
	List<Transaction> findByidAccount (Account idAccount);
	public boolean deleteTransactionById(int id);
	
}
