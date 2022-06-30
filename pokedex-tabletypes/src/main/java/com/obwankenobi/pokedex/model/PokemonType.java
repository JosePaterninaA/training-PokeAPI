package com.obwankenobi.pokedex.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PokemonType {
	
	private String id;
	private String name;
	private List <Weakness> weaknesses;  
}
