package com.obwankenobi.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Weakness {
	private String name; 
	private String damage;
	
}
