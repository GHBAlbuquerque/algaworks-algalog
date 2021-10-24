package com.algaworks.algalog.domain.service.entrega;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public BuscaEntregaService(EntregaRepository entregaRepository) {
		super();
		this.entregaRepository = entregaRepository;
	}

	public Entrega buscar(Long id) {
		return entregaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

}
