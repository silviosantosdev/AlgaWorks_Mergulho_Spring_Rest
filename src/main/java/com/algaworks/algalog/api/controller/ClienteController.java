package com.algaworks.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController  //notação identifica o como componente Spring e capaz de trata requisições HTTP
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	// quando a portas 8080 for chamada por um GET, esse método será convocado e será exibida a mensagem Teste.
	@GetMapping("/clientes") 
	public List<Cliente> listar() {
		return clienteRepository.findAll();

	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	@PutMapping("clienteId")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, 
			@RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
			
		}
		
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
				
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover (@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		
	}
	
		clienteRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();
		
	}

}

////trocado por uma expressão funcional, mais enxuta
//Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//
//if (cliente.isPresent()) {
//	return ResponseEntity.ok(cliente.get());
//}
//
//return ResponseEntity.notFound().build();






// Pode ser substituída pelo @Autowired, vou deixar aqui a título de exemplo
// @PersistenceContext
// private EntityManager manager; 

// return manager.createQuery("from Cliente", Cliente.class)
//		.getResultList();

// @Autowired  //notação do Spring usada quando queremos injetar uma instância que está sendo gerenciada pelo Spring
// private ClienteRepository clienteRepository;