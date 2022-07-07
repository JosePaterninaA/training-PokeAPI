package com.obwankenobi.pokedex.config.exceptions;

import lombok.Builder;

public class PokemonException extends Exception {

	public PokemonException(String message, Throwable cause) {
		super(message, cause);
	}

	@Builder
	public PokemonException(String message){
		super(message);
	}
}
