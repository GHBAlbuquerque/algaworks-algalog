package com.algaworks.algalog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //declara que a classe é um componente com o objetivo de configuração de beans
				//os métodos definirão beans spring
public class ModelMapperConfig {
		
	@Bean //esse método inicializa e configura um bean que será gerenciado pelo spring e disponibilizado para injeção.
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
