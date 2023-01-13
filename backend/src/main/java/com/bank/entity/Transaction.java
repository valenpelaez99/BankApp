package com.bank.entity;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idtransaction")
	private int idTransaction;
	
	@Column(name= "accountnumber")
	private String accountNumber;
	
	@Column(name= "movementdate")
	private LocalDate movementDate;
	
	@Column(name= "transactiontype")
	private String transactionType;
	
	@Column(name= "description")
	private String description;
	
	@Column(name= "value")
	private float value;
	
	@Column(name= "movementtype")
	private String movementType;
	
	@Column(name= "transferaccount")
	private String transferAccount;
	
	@Column(name= "balance")
	private float balance;
	
	@Column(name= "availablebalance")
	private float availableBalance;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idaccount")
	private Account idAccount;

	public Transaction() {
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(LocalDate movementDate) {
		this.movementDate = movementDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public String getTransferAccount() {
		return transferAccount;
	}

	public void setTransferAccount(String transferAccount) {
		this.transferAccount = transferAccount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(float availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Account getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Account idAccount) {
		this.idAccount = idAccount;
	}

	
	
	
	
}
