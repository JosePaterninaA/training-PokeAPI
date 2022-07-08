package com.obwankenobi.pokedex.config;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * API exceptions interceptor
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    /**
     * Generates 404 when exceptions {@link PokemonException}, {@link FeignException} are thrown.
     * @param e
     * @return
     */
    @ExceptionHandler({PokemonException.class, FeignException.class})
    public ResponseEntity<?> notFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
