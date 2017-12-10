package br.com.fourhorsemen.scgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fourhorsemen.scgp.component.ClientComponent;
import br.com.fourhorsemen.scgp.model.Client;

@RestController
@RequestMapping(value = "client")
public class ClientController {
	
	@Autowired
	private ClientComponent clientComponent;
	
	@PostMapping
	public void save(@RequestBody Client client) {
		clientComponent.save(client);
	}
	
	@GetMapping
	public List<Client> listAll() {
		return clientComponent.findAll();
	}
	
	@GetMapping
	@RequestMapping(value = "name/{name}")
	public List<Client> findByName(@PathVariable(value="name") String name) {
		return clientComponent.findByName(name);
	}
}
