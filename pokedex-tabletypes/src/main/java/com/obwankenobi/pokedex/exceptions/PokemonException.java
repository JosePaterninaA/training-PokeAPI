package com.obwankenobi.pokedex.exceptions;

import lombok.Builder;

/**
 * 
 * @author nathaly.salamanca
 *
 */
public class PokemonException extends Exception {

	/**
	 * 
	 * @param message 
	 */
	@Builder
	public PokemonException(String message) {
		super(message);
	}
}
