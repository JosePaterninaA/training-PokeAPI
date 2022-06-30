package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PokemonTableTypes {

    private String id;
    private String name;
    private List<Weaknesses> weaknessesList;
}
