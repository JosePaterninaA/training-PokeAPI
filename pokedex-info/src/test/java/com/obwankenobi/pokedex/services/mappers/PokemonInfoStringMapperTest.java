package com.obwankenobi.pokedex.services.mappers;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.model.PokemonInfo;
import com.obwankenobi.pokedex.services.utils.TestFileLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    void givenValidName_whenJsonDataIsValid_returnPokemonInfo() throws Exception {

        String typeData = TestFileLoader.getJsonFromFileName("pokemon-info-test-response");
        String descriptionData = TestFileLoader.getJsonFromFileName("pokemon-species-test-response");

        PokemonInfo pokemonInfo = pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData,descriptionData);

        assertEquals("25", pokemonInfo.getId());
        assertEquals("pikachu", pokemonInfo.getName());
    }
}
