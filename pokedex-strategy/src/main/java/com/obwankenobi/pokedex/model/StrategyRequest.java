package com.obwankenobi.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contains the input parameter to get a PokemonStrategy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRequest {
    private String name;
}
