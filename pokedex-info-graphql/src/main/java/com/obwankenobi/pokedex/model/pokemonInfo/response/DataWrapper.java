package com.obwankenobi.pokedex.model.pokemonInfo.response;

import lombok.Data;

import java.util.List;
@Data
public class DataWrapper {
    private List<PokemonV2Pokemon> pokemon_v2_pokemon;
}
