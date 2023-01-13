package com.bank.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idclient")
	private int idClient;
	
	@Column(name= "identificationtype")
	private String identificationType;
	
	@Column(name= "identificationnumber")
	private String identificationNumber;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "lastname")
	private String lastName;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "birthdate")
	private LocalDate birthDate;
	
	@Column(name= "creationdate")
	private LocalDate creationDate;
	
	@Column(name= "usercreation")
	private String userCreation;

	@Column(name= "modificationdate")
	private LocalDate modificationDate;
	
	@Column(name= "usermodification")
	private String userModification;
	
	@Column(name= "deleteid")
	private boolean deleteid;

	
	@OneToMany(mappedBy = "idClient")
	private List<Account> account;
	
	
	
	public Client() {
	}



	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public String getIdentificationType() {
		return identificationType;
	}



	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}



	public String getIdentificationNumber() {
		return identificationNumber;
	}



	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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



	public boolean isDeleteid() {
		return deleteid;
	}



	public void setDeleteid(boolean deleteid) {
		this.deleteid = deleteid;
	}



	public List<Account> getAccount() {
		return account;
	}



	public void setAccount(List<Account> account) {
		this.account = account;
	}

	

	
	

	
	
	
}


