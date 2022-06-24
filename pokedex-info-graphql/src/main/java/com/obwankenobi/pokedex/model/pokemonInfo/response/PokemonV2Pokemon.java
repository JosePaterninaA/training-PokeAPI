package com.obwankenobi.pokedex.model.pokemonInfo.response;

import lombok.Data;

import java.util.List;
@Data
public class PokemonV2Pokemon {
    private Long id;
    private String name;
    private List<PokemonV2Pokemontype> pokemon_v2_pokemontypes;
    private PokemonV2Pokemonspecy pokemon_v2_pokemonspecy;
}
