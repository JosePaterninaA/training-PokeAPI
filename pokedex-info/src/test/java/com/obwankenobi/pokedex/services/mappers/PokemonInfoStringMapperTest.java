package com.obwankenobi.pokedex.services.mappers;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonInfoStringMapperTest {

    private static PokemonInfoStringMapper pokemonInfoStringMapper;

    @BeforeAll
    public static void setup(){
        pokemonInfoStringMapper = new PokemonInfoStringMapper();
    }

    @Test
    void givenNullData_throwsInvalidPokemonJsonFormatException() throws Exception {
        String typeData = null;
        String descriptionData = null;

        assertThrows(PokemonException.class, ()->pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData, descriptionData));
    }

    @Test
    void givenEmptyTypeDescriptionData_throwsInvalidPokemonJsonFormatException() throws Exception {
        String typeData = "";
        String descriptionData = "";

        assertThrows(PokemonException.class, ()->pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData, descriptionData));
    }

    @Test
    void givenInvalidJson_throwsInvalidPokemonJsonFormatException() throws Exception {
        String typeData = "{id: 9}";
        String descriptionData = "{id: 9}";

        assertThrows(PokemonException.class, ()->pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData, descriptionData));
    }
}
