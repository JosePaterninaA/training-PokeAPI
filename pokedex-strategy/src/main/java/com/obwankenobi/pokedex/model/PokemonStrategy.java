package com.obwankenobi.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * It has properties id, name and list of weaknesses of a pokemon
 */
@Data
@AllArgsConstructor
@Builder
public class PokemonStrategy {

    private String id;
    private String name;
    private List<TypeWeaknesses> typeWeaknesses;

}
