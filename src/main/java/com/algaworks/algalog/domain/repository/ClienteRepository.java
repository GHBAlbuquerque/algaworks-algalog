package com.algaworks.algalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	//query method
	public List<Cliente> findByNome(String nome);
	
	public List<Cliente> findByNomeContaining(String nome);
	
	public List<Cliente> findByEmail(String email);

}
