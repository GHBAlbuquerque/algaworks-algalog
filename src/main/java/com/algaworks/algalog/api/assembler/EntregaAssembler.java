package com.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.EntregaDTO;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;

@Component //será gerenciado pelo spring
public class EntregaAssembler {
	
	private final ModelMapper mapper;

	public EntregaAssembler(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public EntregaDTO gerarDTO(Entrega entrega) {
		return mapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> gerarListaDTO(List<Entrega> entregas){
		return entregas.stream().map(this::gerarDTO).toList();
	}
	
	public Entrega gerarEntrega(EntregaInput input) {
		return mapper.map(input, Entrega.class);
	}

}
