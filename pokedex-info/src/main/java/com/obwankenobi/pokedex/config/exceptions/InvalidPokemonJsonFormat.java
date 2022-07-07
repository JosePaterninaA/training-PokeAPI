package com.obwankenobi.pokedex.config.exceptions;

public class InvalidPokemonJsonFormat extends PokemonException{
    public InvalidPokemonJsonFormat(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPokemonJsonFormat(String message) {
        super(message);
    }
}
