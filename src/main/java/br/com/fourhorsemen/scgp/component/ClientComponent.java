package br.com.fourhorsemen.scgp.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import br.com.fourhorsemen.scgp.model.Client;
import br.com.fourhorsemen.scgp.repository.ClientRepository;

@Component
public class ClientComponent {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private MongoTemplate template;
	
	public void save(Client client) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("cpf").is(client.getCpf()));
		final Update update = new Update();
		update.set("name", client.getName());
		update.set("lastName", client.getLastName());
		template.upsert(query, update, Client.class);
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public List<Client> findByName(String name) {
		return clientRepository.findByName(name);
	}

	public void delete(String id) {
		clientRepository.deleteById(id);;
	}
}
