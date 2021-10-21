package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class CriaEntregaService {
	
	private final EntregaRepository entregaRepository;
	private final CatalogoClienteService catalogoClienteService;
	
	public CriaEntregaService(EntregaRepository entregaRepository, CatalogoClienteService catalogoClienteService) {
		this.entregaRepository = entregaRepository;
		this.catalogoClienteService = catalogoClienteService;
	}

	@Transactional
	public Entrega criar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setDataPedido(LocalDateTime.now());
		entrega.setStatusEntrega(StatusEntrega.PENDENTE);
		
		return entregaRepository.save(entrega);
	}
}
