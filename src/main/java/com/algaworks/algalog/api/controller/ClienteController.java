package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		var cliente1 = new Cliente(1L, "Kairi", "kairi@kh.com", "112345");
		var cliente2 = new Cliente(2L, "Sora", "sora@kh.com", "212345");
		var cliente3 = new Cliente(3L, "Riku", "riku@kh.com", "312345");
		
		return Arrays.asList(cliente1, cliente2, cliente3);
	}

}
