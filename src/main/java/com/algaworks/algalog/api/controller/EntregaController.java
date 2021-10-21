package com.algaworks.algalog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.CriaEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private CriaEntregaService criaEntregaService;

	public EntregaController(CriaEntregaService criaEntregaService) {
		this.criaEntregaService = criaEntregaService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega criar(@RequestBody Entrega entrega) {
		return criaEntregaService.criar(entrega);
	}

}
