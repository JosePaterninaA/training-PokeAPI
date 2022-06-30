package com.obwankenobi.pokedex.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data que representa un incoming request con el nombre de un pokemon.
 */
@Data
@NoArgsConstructor
public class PokemonRequest {
    private String name;
}
