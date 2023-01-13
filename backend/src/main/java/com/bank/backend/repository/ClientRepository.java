package com.bank.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.backend.entity.Client;


@Repository

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query(value = "SELECT * FROM clients c WHERE c.deleteid = false", nativeQuery = true)
	List <Client> findAll();

}
