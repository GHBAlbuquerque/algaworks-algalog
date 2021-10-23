package com.algaworks.algalog.api.model;

public class ClienteDTO {
	
	private long id;
	private String nome;
	
	public ClienteDTO() {
	}

	public ClienteDTO(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
