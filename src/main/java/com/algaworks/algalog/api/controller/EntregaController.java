package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.CriaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private final EntregaRepository entregaRepository;
	private final CriaEntregaService criaEntregaService;
	
	public EntregaController(EntregaRepository entregaRepository, CriaEntregaService criaEntregaService) {
		this.entregaRepository = entregaRepository;
		this.criaEntregaService = criaEntregaService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega criar(@Valid @RequestBody Entrega entrega) {
		return criaEntregaService.criar(entrega);
	}
	
	@GetMapping
	public List<Entrega> buscar() {
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

}
