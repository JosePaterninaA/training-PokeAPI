package com.obwankenobi.pokedex.exceptions;

/**
 * Excepción genérica para fallas en el consumo o deserialización de datos sobre un Pokemon
 */
public class PokemonInfoException extends Exception{
    public PokemonInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
