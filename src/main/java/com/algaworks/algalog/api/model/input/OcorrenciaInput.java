package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

public class OcorrenciaInput {
	
	@NotBlank
	private String descricao;
	
	public OcorrenciaInput() {
		super();
	}

	public OcorrenciaInput(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
