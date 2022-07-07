package com.obwankenobi.pokedex.config.exceptions;

import lombok.Builder;

public class PokemonException extends Exception {

	@Builder
	public PokemonException(String message, Throwable cause) {
		super(message, cause);
	}

	public PokemonException(String message) {
		super(message);
	}
}
