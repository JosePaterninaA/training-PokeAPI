package com.obwankenobi.pokedex.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.obwankenobi.pokedex.feignclients.PokemonInfoClient;
import com.obwankenobi.pokedex.feignclients.PokemonTableTypesClient;
import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.feignclients.model.Weakness;
import com.obwankenobi.pokedex.model.PokemonStrategy;
import com.obwankenobi.pokedex.model.StrategyRequest;
import com.obwankenobi.pokedex.model.TypeWeaknesses;
import feign.FeignException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class PokemonStrategyServiceTest {

    @InjectMocks
    static PokemonStrategyService pokemonStrategyService;

    @Mock
    PokemonInfoClient pokemonInfoClient;

    @Mock
    PokemonTableTypesClient pokemonTableTypesClient;

    @BeforeAll
    static void setup(){
        pokemonStrategyService = new PokemonStrategyService();
    }

    @Test
    void givenNullName_throwsFeignException(){
        String name = null;
        when(pokemonInfoClient.getPokemonInfo(any(StrategyRequest.class))).thenThrow(FeignException.class);
        assertThrows(FeignException.class, () -> pokemonStrategyService.getPokemonStrategyByName(name));
    }

    @Test
    void givenEmptyName_throwsFeignException(){
        String name = "";
        when(pokemonInfoClient.getPokemonInfo(any(StrategyRequest.class))).thenThrow(FeignException.class);
        assertThrows(FeignException.class, () -> pokemonStrategyService.getPokemonStrategyByName(name));
    }

    @Test
    void givenPikachuAsName_returnStrategyData(){
        String name = "pikachu";

        when(pokemonInfoClient.getPokemonInfo(any(StrategyRequest.class)))
                .thenReturn(new PokemonInfo("25", "pikachu", List.of("electric"), List.of()));
        when(pokemonTableTypesClient.getPokemonTableTypes(any(StrategyRequest.class)))
                .thenReturn(new PokemonTableTypes("25", "pikachu", List.of(
                        new Weakness("ground", "Double"),
                        new Weakness("flying", "Half"),
                        new Weakness("steel", "Half"),
                        new Weakness("electric", "Half")
                )));


        PokemonStrategy pokemonStrategy = pokemonStrategyService.getPokemonStrategyByName(name);

        assertEquals("25", pokemonStrategy.getId());

        assertEquals("pikachu", pokemonStrategy.getName());

        assertTrue(pokemonStrategy.
                getTypeWeaknesses()
                .stream()
                .map(TypeWeaknesses::getType)
                .collect(Collectors.toList())
                .contains("electric")
        );

        assertTrue(pokemonStrategy
                .getTypeWeaknesses()
                .stream()
                .map(TypeWeaknesses::getWeaknessesList)
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .containsAll(List.of(
                    new Weakness("ground", "Double"),
                    new Weakness("flying", "Half"),
                    new Weakness("steel", "Half"),
                    new Weakness("electric", "Half")
                ))
        );

    }

}
