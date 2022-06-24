package com.obwankenobi.pokedex.model.pokemonInfo.response;

import com.obwankenobi.pokedex.model.Response;
import lombok.Data;

@Data
public class PokemonInfoResponse extends Response {
    private DataWrapper data;
}
