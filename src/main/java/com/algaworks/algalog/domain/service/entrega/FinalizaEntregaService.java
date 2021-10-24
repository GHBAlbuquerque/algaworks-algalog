package com.algaworks.algalog.domain.service.entrega;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class FinalizaEntregaService {
	
	private final BuscaEntregaService buscaEntregaService;
	private final EntregaRepository entregaRepository;
	
	public FinalizaEntregaService(BuscaEntregaService buscaEntregaService, EntregaRepository entregaRepository) {
		super();
		this.buscaEntregaService = buscaEntregaService;
		this.entregaRepository = entregaRepository;
	}

	@Transactional
	public void finalizar(Long entregaId) {
		var entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
		
	}
}
