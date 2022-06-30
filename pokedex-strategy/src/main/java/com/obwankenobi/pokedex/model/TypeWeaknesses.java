package com.obwankenobi.pokedex.model;

import com.obwankenobi.pokedex.feignclients.model.Weaknesses;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TypeWeaknesses {
    private String type;
    List<Weaknesses> weaknessesList;
}
