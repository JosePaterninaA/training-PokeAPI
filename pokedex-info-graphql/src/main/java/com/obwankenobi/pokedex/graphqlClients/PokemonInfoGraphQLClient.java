package com.obwankenobi.pokedex.graphqlClients;

import com.obwankenobi.pokedex.model.Request;
import com.obwankenobi.pokedex.model.Response;

public interface PokemonInfoGraphQLClient {
    public Response pokemonInfoResponse(Request request);
}
