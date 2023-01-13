package com.bank.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idaccount")
	private int idAccount;
		
	@Column(name= "accounttype")
	private String accountType;
	
	@Column(name= "accountnumber")
	private String accountNumber;
	
	@Column(name= "accountstatus")
	private String accountStatus;
	
	@Column(name= "balance")
	private float balance;
	
	@Column(name= "availablebalance")
	private float availableBalance;
	
	@Column(name= "nontaxable")
	private String nontaxable;
	
	@Column(name= "creationdate")
	private LocalDate creationDate;
	
	@Column(name= "usercreation")
	private String userCreation;

	@Column(name= "modificationdate")
	private LocalDate modificationDate;
	
	@Column(name= "usermodification")
	private String userModification;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idclient")
	private Client idClient;
	
	@OneToMany(mappedBy = "idAccount")
	private List<Transaction> transaction;

	public Account() {
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
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

	public String getNontaxable() {
		return nontaxable;
	}

	public void setNontaxable(String nontaxable) {
		this.nontaxable = nontaxable;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}

	public LocalDate getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getUserModification() {
		return userModification;
	}

	public void setUserModification(String userModification) {
		this.userModification = userModification;
	}
	
	

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	

	

	

	
	
	
	
}
