package com.obwankenobi.pokedex.config.exceptions;

import lombok.Builder;

public class PokemonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3463356257537722088L;
	
	  @Builder
	  public PokemonException(String message){
	    super(message);
	  }
}
