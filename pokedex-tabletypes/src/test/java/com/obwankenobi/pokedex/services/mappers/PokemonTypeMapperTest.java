package com.obwankenobi.pokedex.services.mappers;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonTypeMapperTest {
    private static PokemonTypeMapper pokemonTypeMapper;

    @BeforeAll
    public static void setup(){
        pokemonTypeMapper = new PokemonTypeMapper();
    }

    @Test
    void givenNullData_throwsInvalidPokemonJsonFormatException() throws Exception {
        String data = null;
        assertThrows(PokemonException.class, ()-> pokemonTypeMapper.getPokemonTypeInfo(data));
    }

    @Test
    void givenEmptyData_throwsInvalidPokemonJsonFormatException() throws Exception {
        String data = "";
        assertThrows(PokemonException.class, ()-> pokemonTypeMapper.getPokemonTypeInfo(data));
    }

    @Test
    void givenInvalidJson_throwsInvalidPokemonJsonFormatException() throws Exception {
        String data = "{id: 9}";
        assertThrows(PokemonException.class, ()-> pokemonTypeMapper.getPokemonTypeInfo(data));
    }
}
