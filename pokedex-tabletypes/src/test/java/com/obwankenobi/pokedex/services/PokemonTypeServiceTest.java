package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.feignclients.PokemonTypeClient;
import feign.FeignException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonTypeServiceTest {
    @InjectMocks
    private static PokemonTypeService pokemonTypeService;

    @Mock
    private PokemonTypeClient pokemonTypeClient;

    @BeforeAll
    public static void setup(){
        pokemonTypeService = new PokemonTypeService();
    }

    @Test
    void givenNullData_whenTypeClientFails_throwsFeignException() throws Exception {
        String name = null;
        when(pokemonTypeClient.getPokemonData(name)).thenThrow(FeignException.class);
        assertThrows(FeignException.class, ()->pokemonTypeService.getPokemonTypeByName(name));
    }
}
