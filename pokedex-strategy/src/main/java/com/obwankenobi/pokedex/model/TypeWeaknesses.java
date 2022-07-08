package com.obwankenobi.pokedex.model;

import com.obwankenobi.pokedex.feignclients.model.Weakness;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * It contains a list of waeknesses associated with a type of pokemon
 */
@Data
@AllArgsConstructor
public class TypeWeaknesses {
    private String type;
    List<Weakness> weaknessesList;
}
