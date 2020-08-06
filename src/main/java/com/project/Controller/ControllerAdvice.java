package com.project.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.project.Exception.ApiErrors;

 
@RestControllerAdvice
public class ControllerAdvice {
    
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handlerValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindngResult = ex.getBindingResult();
		List<String> messages =  bindngResult.getAllErrors()
			.stream()
			.map(objectError -> objectError.getDefaultMessage())
			.collect(Collectors.toList());
	        return new ApiErrors(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ApiErrors> handleResponswStatusException(ResponseStatusException ex) {
		 String mensagemErro = ex.getMessage();
		 HttpStatus codigoStatus = ex.getStatus();
		 ApiErrors apiErrors = new ApiErrors(mensagemErro);
		 return new ResponseEntity<ApiErrors>(apiErrors, codigoStatus);
		
	}
}
