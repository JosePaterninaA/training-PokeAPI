package com.obwankenobi.pokedex.services.mappers;


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
    public void givenEmptyTypeData_returnNull(){
        String typeData = "";
        String descriptionData = "";

        assertNull(pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData, descriptionData));
    }
}
