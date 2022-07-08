package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that contains a list of waeknesses associated with a type of pokemon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weakness {

    private String name;
    private String damage;
}
