package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.algalog.domain.exception.NegocioException;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega statusEntrega;
	
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	@Embedded
	private Destinatario destinatario;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL) 
	//com o cascade type, a persistencia é feita automaticamente quando entrega recebe esse objeto [mesmo sem save]
	private List<Ocorrencia> ocorrencias;

	public Entrega() {}

	public Entrega(Long id, Cliente cliente, BigDecimal taxa, StatusEntrega statusEntrega, OffsetDateTime dataPedido,
			OffsetDateTime dataFinalizacao, Destinatario destinatario) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.taxa = taxa;
		this.statusEntrega = statusEntrega;
		this.dataPedido = dataPedido;
		this.dataFinalizacao = dataFinalizacao;
		this.destinatario = destinatario;
		this.ocorrencias = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
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
	
	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrega other = (Entrega) obj;
		return Objects.equals(id, other.id);
	}

	public Ocorrencia adicionarOcorrencia(String descricao) {
			var ocorrencia = new Ocorrencia(null, descricao, OffsetDateTime.now(), this);
			this.getOcorrencias().add(ocorrencia);
			return ocorrencia;
	}
	
	public boolean podeSerFinalizada() {
		return StatusEntrega.PENDENTE.equals(getStatusEntrega());
	}

	public void finalizar() {
		if(podeSerFinalizada()) {
			this.setStatusEntrega(StatusEntrega.FINALIZADA);
			this.dataFinalizacao = OffsetDateTime.now();
		} else {
			throw new NegocioException("Entrega não pôde ser finalizada");
		}
	}


}
