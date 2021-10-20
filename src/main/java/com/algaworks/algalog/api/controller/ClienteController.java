package com.algaworks.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteController(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	@GetMapping
	public List<Cliente> listar() {
			return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> ObterPorId(@PathVariable Long id) {
		return clienteRepository.findById(id)
				//.map(cliente -> ResponseEntity::ok)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> listarPorNomeContendo(@PathVariable String nome) {
		List<Cliente> clientes = clienteRepository.findByNomeContaining(nome);
		
		if(clientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/nome-completo/{nome}")
	public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
		List<Cliente> clientes = clienteRepository.findByNome(nome);
		
		if(clientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clientes);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable long id, @RequestBody Cliente cliente) {
		if(!clienteRepository.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable long id){
		if(!clienteRepository.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
