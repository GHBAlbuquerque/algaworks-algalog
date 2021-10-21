package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Destinatario {
	
	@Column(name = "destinario_nome")
	private String nome;
	
	@Column(name = "destinario_logradouro")
	private String logradouro;
	
	@Column(name = "destinario_numero")
	private String numero;
	
	@Column(name = "destinario_complemento")
	private String complemento;
	
	@Column(name = "destinario_bairro")
	private String bairro;
	
	public Destinatario() {}

	public Destinatario(String nome, String logradouro, String numero, String complemento, String bairro) {
		super();
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
