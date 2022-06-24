package com.obwankenobi.pokedex.model.pokemonInfo.request;

import com.obwankenobi.pokedex.model.Request;
import lombok.Data;

@Data
public class PokemonInfoRequest extends Request {
    private String name;
}
