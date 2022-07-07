package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class that contains id, name and a list of weaknesses of a pokemon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonTableTypes {

    private String id;
    private String name;
    private List<Weakness> weaknesses;
}
