package com.luigi.testeapi.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.luigi.testeapi.domain.exception.DomainException;
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
 @Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	 List<Problem.Campo> campos = new ArrayList<>();
	 for(ObjectError error : ex.getBindingResult().getAllErrors()) {
		 String nome = ((FieldError) error).getField();
		 String mensagem = error.getDefaultMessage();
		 campos.add(new Problem.Campo(nome, mensagem));
	 }
	 Problem problema = new Problem();
	 problema.setStatus(status.value());
	 problema.setDataHora(OffsetDateTime.now());
	 problema.setTitulo("ONE OR MORE FIELDS ARE INVALID. PLEASE TRY AGAIN");
	 problema.setCampos(campos);
	return handleExceptionInternal(ex, problema, headers, status, request);
}
 	@ExceptionHandler(DomainException.class)
 	public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest wrequest){
 		 HttpStatus status = HttpStatus.BAD_REQUEST;
 		 Problem problema = new Problem();
 		 problema.setStatus(status.value());
 		 problema.setDataHora(OffsetDateTime.now());
 		 problema.setTitulo(ex.getMessage());
 		 
 		
 		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, wrequest);
 	}
}