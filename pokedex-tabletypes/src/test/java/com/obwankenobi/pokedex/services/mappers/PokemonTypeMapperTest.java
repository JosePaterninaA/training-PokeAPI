package com.obwankenobi.pokedex.services.mappers;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.model.Weakness;
import com.obwankenobi.pokedex.services.utils.TestFileLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void givenValidJson_returnsPokemonType() throws Exception {

        String data = TestFileLoader.getJsonFromFileName("pokemon-type-test-response");

        PokemonType pokemonType = pokemonTypeMapper.getPokemonTypeInfo(data);

        assertEquals("10", pokemonType.getId());
        assertEquals("fire", pokemonType.getName());
        assertArrayEquals(List.of(
            new Weakness("ground","Double"),
            new Weakness("rock","Double"),
            new Weakness("water","Double"),
            new Weakness("bug","Half"),
            new Weakness("steel","Half"),
            new Weakness("fire","Half"),
            new Weakness("grass","Half"),
            new Weakness("ice","Half"),
            new Weakness("fairy","Half")
        ).toArray(), pokemonType.getWeaknesses().toArray());
    }
}
