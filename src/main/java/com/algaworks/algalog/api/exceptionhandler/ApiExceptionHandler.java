package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	//ResponseEntityExceptionHandler trata várias exceptions
	
	private final MessageSource messageSource;
	
	public ApiExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<MensagemErro.Campo> campos = new ArrayList<>();
		
//		ex.getBindingResult().getAllErrors()
//		.stream()
//		.map(erro -> (FieldError) erro)
//		.forEach(erro -> campos.add(new MensagemErro.Campo(erro.getField(), erro.getDefaultMessage())));

		ex.getBindingResult().getAllErrors()
		.stream()
		.map(erro -> (FieldError) erro)
		.forEach(erro -> campos.add
				(new MensagemErro
						.Campo(erro.getField(), 
								messageSource.getMessage(erro, LocaleContextHolder.getLocale()))));

	
		var mensagemErro = new MensagemErro();	
		mensagemErro.setStatus(status.value());
		mensagemErro.setDatahora(LocalDateTime.now());
		mensagemErro.setMensagem("Um ou mais campos estão fora do padrão correto!");
		mensagemErro.setCampos(campos);
		return handleExceptionInternal(ex, mensagemErro, headers, status, request);
	}
	

}