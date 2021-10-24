package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.EntregaAssembler;
import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.entrega.CriaEntregaService;
import com.algaworks.algalog.domain.service.entrega.FinalizaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private final EntregaRepository entregaRepository;
	private final CriaEntregaService criaEntregaService;
	private final FinalizaEntregaService finalizaEntregaService;
	private final EntregaAssembler entregaAssembler;
	
	public EntregaController(EntregaRepository entregaRepository, CriaEntregaService criaEntregaService, EntregaAssembler entregaAssembler, FinalizaEntregaService finalizaEntregaService) {
		this.entregaRepository = entregaRepository;
		this.criaEntregaService = criaEntregaService;
		this.entregaAssembler = entregaAssembler;
		this.finalizaEntregaService = finalizaEntregaService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO criar(@Valid @RequestBody EntregaInput input) {
		Entrega entrega = entregaAssembler.gerarEntrega(input);
		var entregaGerada = criaEntregaService.criar(entrega);
		return entregaAssembler.gerarDTO(entregaGerada);
	}
	
	@GetMapping
	public List<EntregaDTO> buscar() {
//		return entregaRepository.findAll()
//				.stream()
//				.map(entregaAssembler::gerarDTO)
//				.toList();
		
		return entregaAssembler.gerarListaDTO(entregaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.gerarDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizaEntregaService.finalizar(entregaId);
	}
	
}
