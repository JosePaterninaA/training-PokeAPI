package com.obwankenobi.pokedex.model;

import com.obwankenobi.pokedex.feignclients.model.Weaknesses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PokemonStrategy {

    private String id;
    private String name;
    private List<TypeWeaknesses> typesTypeWeaknessesList;

}
