package com.obwankenobi.pokedex.config;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.obwankenobi.pokedex.exceptions.PokemonException;

/**
 * This class manage configuration and reponse of exceptions  
 * @author nathaly.salamanca
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

	/**
	 * 
	 * @param e exception
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<?> jsonMappingException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	/**
	 * 
	 * @param e exception
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler({PokemonException.class, FeignException.class})
	public ResponseEntity<?> notFoundException(Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
