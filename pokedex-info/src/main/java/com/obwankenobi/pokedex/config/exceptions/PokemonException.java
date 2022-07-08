package com.obwankenobi.pokedex.config.exceptions;

/**
 * General business exception
 */
public class PokemonException extends Exception {

	public PokemonException(String message, Throwable cause) {
		super(message, cause);
	}

	public PokemonException(String message) {
		super(message);
	}
}
