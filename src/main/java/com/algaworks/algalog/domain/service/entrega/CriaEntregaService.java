package com.algaworks.algalog.domain.service.entrega;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.cliente.CatalogoClienteService;

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
		entrega.setDataPedido(OffsetDateTime.now());
		entrega.setStatusEntrega(StatusEntrega.PENDENTE);
		
		return entregaRepository.save(entrega);
	}
	
}
