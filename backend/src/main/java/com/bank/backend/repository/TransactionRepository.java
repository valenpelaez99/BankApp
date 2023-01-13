package com.bank.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.backend.entity.Account;
import com.bank.backend.entity.Transaction;


@Repository

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
	
	Transaction findByAccountNumber(String accountNumber);
	List<Transaction> findByidAccount (Account idAccount);
}
