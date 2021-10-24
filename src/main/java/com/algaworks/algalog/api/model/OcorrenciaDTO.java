package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

public class OcorrenciaDTO {
	
	private Long id;
	
	private String descricao;
	
	private OffsetDateTime dataRegistro;
	
	public OcorrenciaDTO() {
		super();
	}

	public OcorrenciaDTO(Long id, String descricao, OffsetDateTime dataRegistro) {
		super();
		this.id = id;
		this.setDescricao(descricao);
		this.dataRegistro = dataRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
