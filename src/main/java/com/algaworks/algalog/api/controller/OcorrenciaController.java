package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.api.model.OcorrenciaDTO;
import com.algaworks.algalog.api.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.service.entrega.BuscaEntregaService;
import com.algaworks.algalog.domain.service.ocorrencia.RegistraOcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private final RegistraOcorrenciaService ocorrenciaService; 
	private final BuscaEntregaService buscaEntregaService;
	private final OcorrenciaAssembler ocorrenciaAssembler;
	
	
	public OcorrenciaController(RegistraOcorrenciaService ocorrenciaService, OcorrenciaAssembler ocorrenciaAssembler, BuscaEntregaService buscaEntregaService) {
		super();
		this.ocorrenciaService = ocorrenciaService;
		this.buscaEntregaService = buscaEntregaService;
		this.ocorrenciaAssembler = ocorrenciaAssembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO criar(@PathVariable Long entregaId,  @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		var ocorrencia = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.gerarDTO(ocorrencia);
		
	}
	
	@GetMapping
	public List<OcorrenciaDTO> buscar(@PathVariable Long entregaId){
		var entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.gerarListaDTO(entrega.getOcorrencias());
		
//		return entrega.getOcorrencias().stream()
//				.map(ocorrenciaAssembler::gerarDTO)
//				.findAny()
//				.orElseThrow(() -> new EntidadeNaoEncontradaException("Não há ocorrências registradas para esta entrega"));
		
	}
}
