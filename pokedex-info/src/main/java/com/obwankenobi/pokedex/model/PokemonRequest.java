package com.obwankenobi.pokedex.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data representing an incoming request with the name of the Pokemon.
 */
@Data
@NoArgsConstructor
public class PokemonRequest {
    private String name;
}
