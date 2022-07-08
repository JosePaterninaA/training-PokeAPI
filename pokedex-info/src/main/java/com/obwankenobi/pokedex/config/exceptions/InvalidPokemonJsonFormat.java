package com.obwankenobi.pokedex.config.exceptions;

/**
 * Defines invalid expected json format
 */
public class InvalidPokemonJsonFormat extends PokemonException{
    public InvalidPokemonJsonFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPokemonJsonFormat(String message) {
        super(message);
    }
}
