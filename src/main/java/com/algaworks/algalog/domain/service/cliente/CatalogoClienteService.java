package com.algaworks.algalog.domain.service.cliente;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
	
	private final ClienteRepository clienteRepository;

	public CatalogoClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional //o método deve ser executado dentro de uma transação
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
				//o cliente que eu encontrei é ele mesmo, ou é outro?
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	

}
