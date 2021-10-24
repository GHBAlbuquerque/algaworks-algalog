package com.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OcorrenciaDTO;
import com.algaworks.algalog.domain.model.Ocorrencia;

@Component
public class OcorrenciaAssembler {
	
	private final ModelMapper mapper;
	
	public OcorrenciaAssembler(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public OcorrenciaDTO gerarDTO(Ocorrencia ocorrencia) {
		return mapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> gerarListaDTO(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream().map(this::gerarDTO).toList();
	}
	

}
