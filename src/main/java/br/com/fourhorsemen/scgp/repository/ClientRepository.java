package br.com.fourhorsemen.scgp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fourhorsemen.scgp.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	
	List<Client> findByName(String name);
	
}
