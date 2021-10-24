package com.algaworks.algalog.domain.service.ocorrencia;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.repository.OcorrenciaRepository;
import com.algaworks.algalog.domain.service.entrega.BuscaEntregaService;

@Service
public class RegistroOcorrenciaService {
	
	private final OcorrenciaRepository ocorrenciaRepository;
	private final BuscaEntregaService buscaEntregaService;

	
	public RegistroOcorrenciaService(OcorrenciaRepository ocorrenciaRepository,
			BuscaEntregaService buscaEntregaService) {
		super();
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.buscaEntregaService = buscaEntregaService;
	}


	@Transactional
	public Ocorrencia registrar(Long idEntrega, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(idEntrega);
		//as alterações feitas no objeto serão sincronizadas pelo jakarta persistence
		
		return entrega.adicionarOcorrencia(descricao);	
	}

}
