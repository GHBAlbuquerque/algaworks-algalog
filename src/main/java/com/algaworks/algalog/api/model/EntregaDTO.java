package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;

public class EntregaDTO {
		
	private Long id;
	
	private ClienteDTO cliente; //String clienteNome também funciona
	
	private BigDecimal taxa;
	
	private StatusEntrega statusEntrega;
	
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	private DestinatarioDTO destinatario;

	public EntregaDTO() {}

	public EntregaDTO(Long id, ClienteDTO cliente, BigDecimal taxa, StatusEntrega statusEntrega,
			OffsetDateTime dataPedido, OffsetDateTime dataFinalizacao, DestinatarioDTO destinatarioDTO) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.taxa = taxa;
		this.statusEntrega = statusEntrega;
		this.dataPedido = dataPedido;
		this.dataFinalizacao = dataFinalizacao;
		this.destinatario = destinatarioDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public StatusEntrega getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(StatusEntrega statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public DestinatarioDTO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioDTO destinatario) {
		this.destinatario = destinatario;
	}
	
	
	
	
}
