package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.model.Request;
import com.obwankenobi.pokedex.model.Response;

public interface PokemonInfoService {
    public Response pokemonInfo(Request request);
}
