package com.obwankenobi.pokedex.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.obwankenobi.pokedex.config.exceptions.PokemonException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

	@ExceptionHandler(JsonMappingException.class)
	// @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> jsonMappingException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<?> jsonProcessingException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	@ExceptionHandler(PokemonException.class)
	public ResponseEntity<?> notFoundException(Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
