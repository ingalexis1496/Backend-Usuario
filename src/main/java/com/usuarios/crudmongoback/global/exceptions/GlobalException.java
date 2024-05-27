package com.usuarios.crudmongoback.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usuarios.crudmongoback.global.dto.MessageDto;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto>generalException(Exception e){
		
		return ResponseEntity.internalServerError()
				.body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
	}
	
}
